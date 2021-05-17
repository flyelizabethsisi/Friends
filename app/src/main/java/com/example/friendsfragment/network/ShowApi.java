package com.example.friendsfragment.network;

import com.example.friendsfragment.models.Show;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShowApi {
    @GET("shows/431")
    Call<Show> getShowInfo();
}