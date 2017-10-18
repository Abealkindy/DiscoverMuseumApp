package com.rosinante24.discovermuseumapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rosinante24 on 18/10/17.
 */

public class ResponseProvinsi {
    @SerializedName("data")
    private List<DataProvinsi> dataProvinsiList;

    public List<DataProvinsi> getDataProvinsiList() {
        return dataProvinsiList;
    }

    public class DataProvinsi {
        @SerializedName("kode_wilayah")
        private String kodelWilayahProvinsi;
        @SerializedName("nama")
        private String namaProvinsi;

        public String getKodelWilayahProvinsi() {
            return kodelWilayahProvinsi;
        }

        public String getNamaProvinsi() {
            return namaProvinsi;
        }
    }
}
