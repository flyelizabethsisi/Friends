package com.example.friendsfragment.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.friendsfragment.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OnboardingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OnboardingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button showButton;
    private Button castButton;
    private Button crewButton;
    private Button imageButton;
    private Button seasonButton;
    private Button episodeButton;
    private OnFragmentInteractionListener mListener;

    public OnboardingFragment() {
        // Required empty public constructor
    }

    public static OnboardingFragment newInstance() {
        OnboardingFragment fragment = new OnboardingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
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
        return inflater.inflate(R.layout.fragment_onboarding, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showButton = view.findViewById(R.id.show_button);
        castButton = view.findViewById(R.id.cast_button);
        crewButton = view.findViewById(R.id.crew_button);
        imageButton = view.findViewById(R.id.image_button);
        seasonButton = view.findViewById(R.id.season_button);
        episodeButton = view.findViewById(R.id.episode_button);

        showButton.setOnClickListener(clickListener);
        castButton.setOnClickListener(clickListener);
        crewButton.setOnClickListener(clickListener);
        imageButton.setOnClickListener(clickListener);
        seasonButton.setOnClickListener(clickListener);
        episodeButton.setOnClickListener(clickListener);

    }
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.show_button:
                  if(mListener!=null)mListener.showOnFragmentInteraction();
                    break;
                case R.id.cast_button:
                  if(mListener!=null)mListener.castOnFragmentInteraction();
                    break;
                case R.id.crew_button:
                   if(mListener!=null)mListener.crewOnFragmentInteraction();
                    break;
                case R.id.image_button:
                   if(mListener!=null)mListener.imageOnFragmentInteraction();
                    break;
                case R.id.season_button:
                   if(mListener!=null)mListener.seasonOnFragmentInteraction();
                    break;
                case R.id.episode_button:
                   if(mListener!=null)mListener.episodeOnFragmentInteraction();
                    break;

            }
        }
    };

    public interface OnFragmentInteractionListener{
        void showOnFragmentInteraction();
        void castOnFragmentInteraction();
        void crewOnFragmentInteraction();
        void imageOnFragmentInteraction();
        void seasonOnFragmentInteraction();
        void episodeOnFragmentInteraction();
    }
}