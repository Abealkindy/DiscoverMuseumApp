package com.rosinante24.discovermuseumapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rosinante24 on 18/10/17.
 */

public class ResponseMuseum {
    @SerializedName("data")
    private List<DataMuseum> dataMuseumList;

    public List<DataMuseum> getDataMuseumList() {
        return dataMuseumList;
    }

    public class DataMuseum {
        @SerializedName("nama")
        private String namaMuseum;
        @SerializedName("alamat_jalan")
        private String alamatJalanMuseum;
        @SerializedName("kecamatan")
        private String kecamatanMuseum;
        @SerializedName("kabupaten_kota")
        private String kabupatenKotaMuseum;
        @SerializedName("propinsi")
        private String provinsiMuseum;
        @SerializedName("koleksi")
        private String koleksiMuseum;
        @SerializedName("pengelola")
        private String pengelolaMuseum;
        @SerializedName("tipe")
        private String tipeMuseum;
        @SerializedName("standar")
        private String standarMuseum;
        @SerializedName("tahun_berdiri")
        private String tahunBerdiriMuseum;
        @SerializedName("bangunan")
        private String bangunanMuseum;
        @SerializedName("luas_tanah")
        private String luasTanahMuseum;

        public String getNamaMuseum() {
            return namaMuseum;
        }

        public String getAlamatJalanMuseum() {
            return alamatJalanMuseum;
        }

        public String getKecamatanMuseum() {
            return kecamatanMuseum;
        }

        public String getKabupatenKotaMuseum() {
            return kabupatenKotaMuseum;
        }

        public String getProvinsiMuseum() {
            return provinsiMuseum;
        }

        public String getKoleksiMuseum() {
            return koleksiMuseum;
        }

        public String getPengelolaMuseum() {
            return pengelolaMuseum;
        }

        public String getTipeMuseum() {
            return tipeMuseum;
        }

        public String getStandarMuseum() {
            return standarMuseum;
        }

        public String getTahunBerdiriMuseum() {
            return tahunBerdiriMuseum;
        }

        public String getBangunanMuseum() {
            return bangunanMuseum;
        }

        public String getLuasTanahMuseum() {
            return luasTanahMuseum;
        }
    }
}
