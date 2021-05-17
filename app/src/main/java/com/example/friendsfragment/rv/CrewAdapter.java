package com.example.friendsfragment.rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.Crew;

import java.util.List;

public class CrewAdapter extends RecyclerView.Adapter<CrewViewHolder> {
    private List<Crew> crews;

    public CrewAdapter(List<Crew> crews) {
        this.crews = crews;
    }


    @NonNull
    @Override
    public CrewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crew_item_view, parent, false);
        return new CrewViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CrewViewHolder holder, int position) {
        holder.onBind(crews.get(position));
    }

    @Override
    public int getItemCount() {
        return crews.size();
    }
}
