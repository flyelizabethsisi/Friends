package com.example.friendsfragment.rv;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.ShowImage;
import com.squareup.picasso.Picasso;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;


    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.images);

    }
    public void onBind(ShowImage showImage) {
        Picasso.get().load(showImage.getResolutions().getOriginal().getUrl())
                .into(image);

    }
}
