package com.rosinante24.discovermuseumapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.rosinante24.discovermuseumapp.Adapter.AdapterRecyclerMuseum;
import com.rosinante24.discovermuseumapp.Fonts.Fonts;
import com.rosinante24.discovermuseumapp.Model.ResponseMuseum;
import com.rosinante24.discovermuseumapp.Network.ApiServices;
import com.rosinante24.discovermuseumapp.Network.InitRetrofit;
import com.rosinante24.discovermuseumapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMuseumActivity extends AppCompatActivity {

    @BindView(R.id.textTitleMuseum)
    TextView textTitleMuseum;
    @BindView(R.id.recyclerListMuseum)
    RecyclerView recyclerListMuseum;

    private String id_kota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_museum);
        ButterKnife.bind(this);
        Fonts.RobotoRegular(this, textTitleMuseum);
        id_kota = getIntent().getStringExtra("id_kota");
        getDataMuseum(id_kota);
    }

    private void getDataMuseum(String id_kota) {
        ApiServices api = InitRetrofit.getInstances();
        Call<ResponseMuseum> call = api.getMuseum(id_kota);
        call.enqueue(new Callback<ResponseMuseum>() {
            @Override
            public void onResponse(Call<ResponseMuseum> call, Response<ResponseMuseum> response) {
                List<ResponseMuseum.DataMuseum> dataMuseum = response.body().getDataMuseumList();
                AdapterRecyclerMuseum adapter = new AdapterRecyclerMuseum(dataMuseum, getApplicationContext());
                recyclerListMuseum.setAdapter(adapter);
                recyclerListMuseum.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<ResponseMuseum> call, Throwable t) {

            }
        });
    }
}
