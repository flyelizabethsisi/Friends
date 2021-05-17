package com.example.friendsfragment.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.Episode;
import com.example.friendsfragment.network.EpisodeRetrofit;
import com.example.friendsfragment.network.TvmazApi;
import com.example.friendsfragment.rv.EpisodeAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EpisodeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EpisodeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "EpisodeActivityError";
    RecyclerView episodeRecycerView;
    EpisodeAdapter episodeAdapter;
    List<Episode> episodeList = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EpisodeFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static EpisodeFragment newInstance() {
        EpisodeFragment fragment = new EpisodeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_episode, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        episodeRecycerView = view.findViewById(R.id.episode_recyclerview);
        // getCastInfo();

        Retrofit episodeRetrofit = EpisodeRetrofit.getEpisodeRetrofit();
        Log.d(TAG, "ellie" + episodeRetrofit.toString());

        TvmazApi tvmazApi = episodeRetrofit.create(TvmazApi.class);
        Log.d(TAG, "eelll" + tvmazApi.toString());
        Call<List<Episode>> responseCall = tvmazApi.getEpisodesInfo();
        responseCall.enqueue(new Callback<List<Episode>>() {
            @Override
            public void onResponse(Call<List<Episode>> call, Response<List<Episode>> response) {
                episodeList = response.body();
                episodeAdapter = new EpisodeAdapter(episodeList);
                episodeRecycerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                episodeRecycerView.setAdapter(episodeAdapter);
            }

            @Override
            public void onFailure(Call<List<Episode>> call, Throwable t) {

            }
        });
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
}