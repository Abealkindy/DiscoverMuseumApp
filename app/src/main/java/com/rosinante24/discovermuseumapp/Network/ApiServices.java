package com.rosinante24.discovermuseumapp.Network;

import com.rosinante24.discovermuseumapp.Model.ResponseKota;
import com.rosinante24.discovermuseumapp.Model.ResponseMuseum;
import com.rosinante24.discovermuseumapp.Model.ResponseProvinsi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rosinante24 on 18/10/17.
 */

public interface ApiServices {
    @GET("CWilayah/wilayahGET")
    Call<ResponseProvinsi> getProvinsi();

    @GET("CWilayah/wilayahGET")
    Call<ResponseKota> getKota(
            @Query("mst_kode_wilayah") String kodeProvinsi
    );

    @GET("CcariMuseum/searchGET")
    Call<ResponseMuseum> getMuseum(
            @Query("kode_kab_kota") String kodeKotaKbupaten
    );
}
