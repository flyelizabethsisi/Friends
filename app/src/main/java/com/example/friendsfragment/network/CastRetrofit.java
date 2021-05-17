package com.example.friendsfragment.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CastRetrofit {
    private static final String TVMAZ_BASE_URL = "http://api.tvmaze.com";
    private static Retrofit instance;


    public CastRetrofit() {
    }

    public static Retrofit getCastRetrofit() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(TVMAZ_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }


}