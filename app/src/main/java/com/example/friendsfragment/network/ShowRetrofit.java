package com.example.friendsfragment.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowRetrofit { private static final String TVMAZ_BASE_URL = "http://api.tvmaze.com/";
    private static Retrofit instance;
    // http://api.tvmaze.com/shows/431/cast

    public ShowRetrofit() {
    }

    public static Retrofit getShowRetrofit() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(TVMAZ_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}


