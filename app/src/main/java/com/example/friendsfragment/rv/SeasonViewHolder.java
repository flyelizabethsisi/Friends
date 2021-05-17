package com.example.friendsfragment.rv;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.Season;
import com.squareup.picasso.Picasso;

public class SeasonViewHolder extends RecyclerView.ViewHolder {
    private TextView seasonNumber;
    private TextView seasonEpisodeNumber;
    private TextView seasonPremiere;
    private TextView seasonEnd;
    private ImageView seasonImage;


    public SeasonViewHolder(@NonNull View itemView) {
        super(itemView);
        seasonNumber = itemView.findViewById(R.id.season_number);
        seasonEpisodeNumber = itemView.findViewById(R.id.season_episode_number);
        seasonEnd = itemView.findViewById(R.id.season_enddate);
        seasonPremiere = itemView.findViewById(R.id.seson_premieredate);
        seasonImage = itemView.findViewById(R.id.season_image);
    }
    @SuppressLint("SetTextI18n")
    public void onBind(Season season) {
        seasonNumber.setText(itemView.getContext().getString(R.string.season_number) + season.getNumber());
        seasonEpisodeNumber.setText(itemView.getContext().getString(R.string.season_episode_order) + season.getEpisodeOrder());
        seasonEnd.setText(itemView.getContext().getString(R.string.season_end_date) + season.getEndDate());
        seasonPremiere.setText(itemView.getContext().getString(R.string.season_premiere_date) + season.getPremiereDate());
        Picasso.get().load(season.getImage().getOriginal())
                .into(seasonImage);

    }

}
