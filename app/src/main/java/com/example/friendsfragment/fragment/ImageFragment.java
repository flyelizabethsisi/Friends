package com.example.friendsfragment.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.ShowImage;
import com.example.friendsfragment.network.ImageRetrofit;
import com.example.friendsfragment.network.TvmazApi;
import com.example.friendsfragment.rv.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static final String TAG = "ImageFragmentError";
    RecyclerView imageRecyclerView;
    ImageAdapter imageAdapter;
    List<ShowImage> imageList = new ArrayList<>();

    public ImageFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ImageFragment newInstance() {
        ImageFragment fragment = new ImageFragment();
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
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageRecyclerView= view.findViewById(R.id.image_recyclerview);

        Retrofit imageRetrofit = ImageRetrofit.getImageRetrofit();

        TvmazApi tvmazApi = imageRetrofit.create(TvmazApi.class);
        Call<List<ShowImage>> responseCall = tvmazApi.getImages();
        responseCall.enqueue(new Callback<List<ShowImage>>() {
            @Override
            public void onResponse(Call<List<ShowImage>> call, Response<List<ShowImage>> response) {
                imageList = response.body();
                imageAdapter = new ImageAdapter(imageList);
                imageRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                imageRecyclerView.setAdapter(imageAdapter);
            }

            @Override
            public void onFailure(Call<List<ShowImage>> call, Throwable t) {

            }
        });
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }
}