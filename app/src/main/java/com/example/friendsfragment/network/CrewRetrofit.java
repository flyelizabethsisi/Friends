package com.example.friendsfragment.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrewRetrofit {
    private static final String TVMAZ_BASE_URL = "http://api.tvmaze.com";
    private static Retrofit instance;


    public CrewRetrofit() {
    }

    public static Retrofit getCrewRetrofit() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(TVMAZ_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}


