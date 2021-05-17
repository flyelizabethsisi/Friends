package com.example.friendsfragment.network;

import com.example.friendsfragment.models.CastWrapper;
import com.example.friendsfragment.models.Crew;
import com.example.friendsfragment.models.Episode;
import com.example.friendsfragment.models.Season;
import com.example.friendsfragment.models.ShowImage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TvmazApi {
    @GET("/shows/431/cast")
    Call<List<CastWrapper>> getCastInfo();

    @GET("/shows/431/images")
    Call<List<ShowImage>> getImages();

//    @GET("/shows/431")
//    Observable<Show> getShow();

    @GET("/shows/431/seasons")
        // Observable<Season> getSesonsInfo(@Path("TvmazID")Integer tvmazNumber);
    Call<List<Season>> getSeasonInfo();

    @GET("/shows/431/episodes")
    Call<List<Episode>> getEpisodesInfo();

    @GET("/shows/431/crew")
    Call<List<Crew>> getCrewInfo();
}
