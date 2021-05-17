package com.example.friendsfragment.rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.Season;

import java.util.List;

public class SeasonAdapter extends RecyclerView.Adapter<SeasonViewHolder> {
    private List<Season> seasons;

    public SeasonAdapter(List<Season> seasons) {
        this.seasons = seasons;
    }

    @NonNull
    @Override
    public SeasonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.season_item_view, parent, false);
        return new SeasonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeasonViewHolder holder, int position) {
        holder.onBind(seasons.get(position));
    }

    @Override
    public int getItemCount() {
        return seasons.size();
    }
}
