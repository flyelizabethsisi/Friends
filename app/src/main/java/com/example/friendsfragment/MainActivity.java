package com.example.friendsfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.friendsfragment.fragment.CastFragment;
import com.example.friendsfragment.fragment.CrewFragment;
import com.example.friendsfragment.fragment.EpisodeFragment;
import com.example.friendsfragment.fragment.FragmentInterface;
import com.example.friendsfragment.fragment.ImageFragment;
import com.example.friendsfragment.fragment.OnboardingFragment;
import com.example.friendsfragment.fragment.SeasonFragment;
import com.example.friendsfragment.fragment.ShowFragment;
import com.example.friendsfragment.fragment.SplashFragment;
import com.example.friendsfragment.models.Crew;

public class MainActivity extends AppCompatActivity implements FragmentInterface, OnboardingFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toSplashFragment();

    }

    @Override
    public void toOnboardingFragment() {
        OnboardingFragment onboardingFragment = OnboardingFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, onboardingFragment)
                .commit();

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void toSplashFragment() {
        SplashFragment splashFragment = SplashFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, splashFragment)
                .commit();

    }

    @Override
    public void showOnFragmentInteraction() {
        toShowFragment();
    }


    @Override
    public void castOnFragmentInteraction() {
        toCastFragment();
    }

    @Override
    public void crewOnFragmentInteraction() {
        toCrewFragment();

    }

    @Override
    public void imageOnFragmentInteraction() {
        toImagineFragment();
    }

    @Override
    public void seasonOnFragmentInteraction() {
        toSeasonFragment();
    }

    @Override
    public void episodeOnFragmentInteraction() {
        toEpisodeFragment();
    }

    public void toShowFragment() {
        ShowFragment showFragment = ShowFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, showFragment)
                .addToBackStack(null)
                .commit();
    }

    public void toCastFragment() {
        CastFragment castFragment = CastFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, castFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toCrewFragment() {
        CrewFragment crewFragment = CrewFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, crewFragment)
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void toEpisodeFragment() {
        EpisodeFragment episodeFragment = EpisodeFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, episodeFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toImagineFragment() {
        ImageFragment imageFragment = ImageFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, imageFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toSeasonFragment() {
        SeasonFragment seasonFragment = SeasonFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, seasonFragment)
                .addToBackStack(null)
                .commit();
    }
}