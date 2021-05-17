package com.example.friendsfragment.rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.Episode;

import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {
    private List<Episode> episodes;

    public EpisodeAdapter(List<Episode> episodes) {
        this.episodes = episodes;
    }


    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.episode_item_view, parent, false);
        return new EpisodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        holder.onBind(episodes.get(position));

    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }
}
