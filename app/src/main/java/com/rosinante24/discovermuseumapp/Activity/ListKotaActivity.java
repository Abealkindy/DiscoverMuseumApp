package com.rosinante24.discovermuseumapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.rosinante24.discovermuseumapp.Adapter.AdapterRecyclerKota;
import com.rosinante24.discovermuseumapp.Fonts.Fonts;
import com.rosinante24.discovermuseumapp.Model.ResponseKota;
import com.rosinante24.discovermuseumapp.Network.ApiServices;
import com.rosinante24.discovermuseumapp.Network.InitRetrofit;
import com.rosinante24.discovermuseumapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListKotaActivity extends AppCompatActivity {

    @BindView(R.id.textTitleListKota)
    TextView textTitleListKota;
    @BindView(R.id.recyclerListKota)
    RecyclerView recyclerListKota;
    private String id_provinsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kota);
        ButterKnife.bind(this);
        Fonts.RobotoRegular(this, textTitleListKota);
        id_provinsi = getIntent().getStringExtra("id_provinsi");
        getDataKota(id_provinsi);
    }

    private void getDataKota(String id_provinsi) {
        ApiServices api = InitRetrofit.getInstances();
        Call<ResponseKota> call = api.getKota(id_provinsi);
        call.enqueue(new Callback<ResponseKota>() {
            @Override
            public void onResponse(Call<ResponseKota> call, Response<ResponseKota> response) {
                if (response.isSuccessful()) {
                    List<ResponseKota.DataKota> dataKota = response.body().getDataKotaList();
                    AdapterRecyclerKota adapter = new AdapterRecyclerKota(dataKota, getApplicationContext());
                    recyclerListKota.setAdapter(adapter);
                    recyclerListKota.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<ResponseKota> call, Throwable t) {

            }
        });
    }
}
