package com.example.friendsfragment.fragment;

import android.content.Context;
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
import com.example.friendsfragment.models.CastWrapper;
import com.example.friendsfragment.network.CastRetrofit;
import com.example.friendsfragment.network.TvmazApi;
import com.example.friendsfragment.rv.CastAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CastFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentInterface fragmentInterface;
    private static final String TAG = "CastActivityError";
    RecyclerView castRecyclerView;
    CastAdapter castAdapter;
    List<CastWrapper> castList = new ArrayList<>();


    public CastFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CastFragment newInstance() {
        CastFragment fragment = new CastFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentInterface){
            fragmentInterface = (FragmentInterface)context;
        }else {
            throw new RuntimeException(context.toString()
                    +" must implement OnFragmentInteractionListener");
        }
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
        return inflater.inflate(R.layout.fragment_cast, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        castRecyclerView = view.findViewById(R.id.cast_recyclerview);
        // getCastInfo();

        Retrofit castRetrofit = CastRetrofit.getCastRetrofit();
        Log.d(TAG, "ellie" + castRetrofit.toString());

        TvmazApi tvmazApi = castRetrofit.create(TvmazApi.class);
        Log.d(TAG, "eelll" + tvmazApi.toString());

        Call<List<CastWrapper>> resultCall = tvmazApi.getCastInfo();
        resultCall.enqueue(new Callback<List<CastWrapper>>() {
            @Override
            public void onResponse(Call<List<CastWrapper>> call, Response<List<CastWrapper>> response) {
                Log.d(TAG, "eefefe" + response.body().get(0).getPerson().getName());
                Log.d(TAG, "ddddd" + response.body().get(0).getCharacter().getName());

                castList = response.body();
                castAdapter = new CastAdapter(castList);
                castRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                castRecyclerView.setAdapter(castAdapter);

            }

            @Override
            public void onFailure(Call<List<CastWrapper>> call, Throwable t) {

            }
        });
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
}