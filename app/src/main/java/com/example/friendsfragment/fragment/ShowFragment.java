package com.example.friendsfragment.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.Show;
import com.example.friendsfragment.network.ShowApi;
import com.example.friendsfragment.network.ShowRetrofit;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowFragment extends Fragment {
    private static final String TAG = "ShowFragmentError";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentInterface fragmentInterface;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShowFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ShowFragment newInstance() {
        ShowFragment fragment = new ShowFragment();
        Bundle args = new Bundle();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView showName = view.findViewById(R.id.show_name);
        TextView showPremiered = view.findViewById(R.id.show_premiered);
        TextView showSummary = view.findViewById(R.id.show_summary);
        ImageView showImage = view.findViewById(R.id.show_image);

        final Retrofit showRetrofit = ShowRetrofit.getShowRetrofit();
        ShowApi showApi = showRetrofit.create(ShowApi.class);
        Call<Show> showCall = showApi.getShowInfo();
        showCall.enqueue(new Callback<Show>() {
            @Override
            public void onResponse(Call<Show> call, Response<Show> response) {
                Log.d(TAG, response.body().getName());
                String imageShow = response.body().getImage().getOriginal();
                Picasso.get().load(imageShow).into(showImage);
                String nameShow = response.body().getName();
                showName.setText(nameShow);

                String summaryShow = response.body().getSummary();
                if (!summaryShow.isEmpty()) {
                    String newSummaryShow = response.body().getSummary().replaceAll("</p>", "").replaceAll("<p>", "");
                    showSummary.setText(newSummaryShow);
                }
                String premieredShow = response.body().getPremiered();
                showPremiered.setText(getString(R.string.premiere_date) + premieredShow);

            }

            @Override
            public void onFailure(Call<Show> call, Throwable t) {

            }
        });

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}