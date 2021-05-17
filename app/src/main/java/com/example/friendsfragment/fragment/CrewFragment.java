package com.example.friendsfragment.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.Crew;
import com.example.friendsfragment.network.CrewRetrofit;
import com.example.friendsfragment.network.TvmazApi;
import com.example.friendsfragment.rv.CrewAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "CrewFragmentError";
    RecyclerView crewRecyclerView;
    Retrofit crewRetrofit;
    CrewAdapter crewAdapter;
    List<Crew> crewList = new ArrayList<>();


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CrewFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CrewFragment newInstance() {
        CrewFragment fragment = new CrewFragment();
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
        return inflater.inflate(R.layout.fragment_crew, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        crewRecyclerView = view.findViewById(R.id.crew_recyclerview);
        crewRetrofit = CrewRetrofit.getCrewRetrofit();
        TvmazApi tvmazApi = crewRetrofit.create(TvmazApi.class);

        Call<List<Crew>> resultCall = tvmazApi.getCrewInfo();
        resultCall.enqueue(new Callback<List<Crew>>() {
            @Override
            public void onResponse(Call<List<Crew>> call, Response<List<Crew>> response) {
                crewList = response.body();
                crewAdapter = new CrewAdapter(crewList);
                crewRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
                crewRecyclerView.setAdapter(crewAdapter);
            }

            @Override
            public void onFailure(Call<List<Crew>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}