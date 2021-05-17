package com.example.friendsfragment.rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.CastWrapper;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastViewHolder> {
    private List<CastWrapper> castList;

    public CastAdapter(List<CastWrapper> castList) {
        this.castList = castList;
    }


    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_item_view, parent, false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {
        holder.onBind(castList.get(position));
    }

    @Override
    public int getItemCount() {

        return castList.size();
    }
}

