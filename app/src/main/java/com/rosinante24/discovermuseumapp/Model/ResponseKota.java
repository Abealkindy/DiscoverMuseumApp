package com.rosinante24.discovermuseumapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rosinante24 on 18/10/17.
 */

public class ResponseKota {
    @SerializedName("data")
    private List<DataKota> dataKotaList;

    public List<DataKota> getDataKotaList() {
        return dataKotaList;
    }

    public class DataKota {
        @SerializedName("kode_wilayah")
        private String kodeWilayahKota;
        @SerializedName("nama")
        private String namaKota;

        public String getKodeWilayahKota() {
            return kodeWilayahKota;
        }

        public String getNamaKota() {
            return namaKota;
        }
    }
}
