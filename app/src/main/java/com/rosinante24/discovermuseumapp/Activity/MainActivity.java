package com.rosinante24.discovermuseumapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.rosinante24.discovermuseumapp.Adapter.AdapterRecyclerMain;
import com.rosinante24.discovermuseumapp.Fonts.Fonts;
import com.rosinante24.discovermuseumapp.Model.ResponseProvinsi;
import com.rosinante24.discovermuseumapp.Network.ApiServices;
import com.rosinante24.discovermuseumapp.Network.InitRetrofit;
import com.rosinante24.discovermuseumapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textTitleMainActivity)
    TextView textTitleMainActivity;
    @BindView(R.id.recyclerProvinsi)
    RecyclerView recyclerProvinsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Fonts.RobotoRegular(this, textTitleMainActivity);
        getDataProvinsi();
    }

    private void getDataProvinsi() {
        ApiServices api = InitRetrofit.getInstances();
        Call<ResponseProvinsi> call = api.getProvinsi();
        call.enqueue(new Callback<ResponseProvinsi>() {
            @Override
            public void onResponse(Call<ResponseProvinsi> call, Response<ResponseProvinsi> response) {
                if (response.isSuccessful()) {
                    List<ResponseProvinsi.DataProvinsi> dataProvinsi = response.body().getDataProvinsiList();
                    AdapterRecyclerMain adapter = new AdapterRecyclerMain(dataProvinsi, getApplicationContext());
                    recyclerProvinsi.setAdapter(adapter);
                    recyclerProvinsi.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<ResponseProvinsi> call, Throwable t) {

            }
        });
    }
}
