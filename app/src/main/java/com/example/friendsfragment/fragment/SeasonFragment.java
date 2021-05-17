package com.example.friendsfragment.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.Season;
import com.example.friendsfragment.network.SeasonRetrofit;
import com.example.friendsfragment.network.TvmazApi;
import com.example.friendsfragment.rv.SeasonAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SeasonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeasonFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "SeasonFragmentError";
    RecyclerView seasonRecyclerView;
    SeasonAdapter seasonAdapter;
    List<Season> seasonList = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SeasonFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SeasonFragment newInstance() {
        SeasonFragment fragment = new SeasonFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_season, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        seasonRecyclerView = view.findViewById(R.id.season_recyclerview);

        Retrofit seasonRetrofit = SeasonRetrofit.getCastRetrofit();
        TvmazApi tvmazApi = seasonRetrofit.create(TvmazApi.class);
        Call<List<Season>> responseCall = tvmazApi.getSeasonInfo();
        responseCall.enqueue(new Callback<List<Season>>() {
            @Override
            public void onResponse(Call<List<Season>> call, Response<List<Season>> response) {
                Log.d(TAG, "wwww" + response.body().get(0).getEndDate());
                seasonList = response.body();
                seasonAdapter = new SeasonAdapter(seasonList);
                seasonRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                seasonRecyclerView.setAdapter(seasonAdapter);
            }

            @Override
            public void onFailure(Call<List<Season>> call, Throwable t) {

            }
        });

    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
}