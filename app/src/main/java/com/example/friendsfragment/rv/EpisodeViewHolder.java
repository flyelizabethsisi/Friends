package com.example.friendsfragment.rv;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.Episode;
import com.squareup.picasso.Picasso;

public class EpisodeViewHolder extends RecyclerView.ViewHolder {
    private Button epidosdeUrlButton;
    private TextView epidsodeName;
    private TextView episodeSeason;
    private TextView episdoeNumber;
    private TextView episodeAirdate;
    private ImageView episodeImage;
    private TextView episdoeSummary;


    public EpisodeViewHolder(@NonNull View itemView) {
        super(itemView);
        epidosdeUrlButton = itemView.findViewById(R.id.episode_url_button);
        epidsodeName = itemView.findViewById(R.id.episode_name);
        episodeSeason = itemView.findViewById(R.id.episode_season);
        episdoeNumber = itemView.findViewById(R.id.episode_number);
        episodeAirdate = itemView.findViewById(R.id.episode_airdate);
        episodeImage = itemView.findViewById(R.id.episode_image);
        episdoeSummary = itemView.findViewById(R.id.episode_summary);

    }

    @SuppressLint("SetTextI18n")
    public void onBind(Episode episode) {
        epidosdeUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri episodeUri = Uri.parse(episode.getUrl());
                Intent episodeIntent = new Intent(Intent.ACTION_VIEW, episodeUri);
                itemView.getContext().startActivity(episodeIntent);
            }
        });
        epidsodeName.setText(itemView.getContext().getString(R.string.episode_title) + episode.getName());
        episodeSeason.setText(itemView.getContext().getString(R.string.season_number) + episode.getSeason());
        episdoeNumber.setText(itemView.getContext().getString(R.string.season_episode_order) + episode.getNumber());
        episodeAirdate.setText(itemView.getContext().getString(R.string.episode_airdate) + episode.getAirdate());
        episdoeSummary.setText(episode.getSummary().replaceAll("</p>", " ").replaceAll("<p>", " "));

        Picasso.get().load(episode.getImage().getOriginal())
                .resize(80, 80)
                .into(episodeImage);

    }
}
