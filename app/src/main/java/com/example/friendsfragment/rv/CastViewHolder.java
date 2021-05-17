package com.example.friendsfragment.rv;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.CastWrapper;
import com.squareup.picasso.Picasso;

public class CastViewHolder extends RecyclerView.ViewHolder {
    private TextView castPersonName;
    private TextView castBirthday;
    private Button castUrl;
    private ImageView personImage;

    private TextView chaName;
    private Button chaUrl;
    private ImageView chaImage;


    public CastViewHolder(@NonNull View itemView) {
        super(itemView);
        castPersonName = itemView.findViewById(R.id.person_name);
        castBirthday = itemView.findViewById(R.id.person_birthday);
        castUrl = itemView.findViewById(R.id.person_url);
        personImage = itemView.findViewById(R.id.person_image);

        chaName = itemView.findViewById(R.id.char_name);
        chaUrl = itemView.findViewById(R.id.char_url);
        chaImage = itemView.findViewById(R.id.char_image);
    }

    public void onBind(CastWrapper castWrapper) {
        castPersonName.setText(castWrapper.person.getName());
        castBirthday.setText(castWrapper.person.getBirthday());
        castUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri castUri = Uri.parse(castWrapper.person.getUrl());
                Intent castPersonIntent = new Intent(Intent.ACTION_VIEW, castUri);
                itemView.getContext().startActivity(castPersonIntent);
            }
        });

        Picasso.get().load(castWrapper.person.getImage().getOriginal())
                .resize(80, 100)
                .into(personImage);

        Picasso.get().load(castWrapper.character.getImage().getOriginal())
                .resize(80, 100)
                .into(chaImage);
        chaName.setText(castWrapper.character.getName());
        chaUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri castChaUni = Uri.parse(castWrapper.character.getUrl());
                Intent castChaIntent = new Intent(Intent.ACTION_VIEW, castChaUni);
                itemView.getContext().startActivity(castChaIntent);
            }
        });


    }
}
