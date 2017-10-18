package com.rosinante24.discovermuseumapp.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rosinante24 on 18/10/17.
 */

public class InitRetrofit {

    public static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl("http://jendela.data.kemdikbud.go.id/api/index.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiServices getInstances() {
        return setInit().create(ApiServices.class);
    }

}
