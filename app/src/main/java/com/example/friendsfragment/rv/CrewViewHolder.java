package com.example.friendsfragment.rv;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.friendsfragment.R;
import com.example.friendsfragment.models.Crew;

public class CrewViewHolder extends RecyclerView.ViewHolder {

    private TextView crewType;
    private TextView crewName;
    private Button crewUrlButton;


    public CrewViewHolder(@NonNull View itemView) {
        super(itemView);
        crewType = itemView.findViewById(R.id.type_name);

        crewName = itemView.findViewById(R.id.crew_name);
        crewUrlButton = itemView.findViewById(R.id.crew_more_button);

    }

    public void onBind(Crew crew) {
        crewType.setText(crew.getType());
        crewName.setText(crew.getPerson().getName());
        crewUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri crewUri = Uri.parse(crew.getPerson().getUrl());
                Intent crewIntent = new Intent(Intent.ACTION_VIEW, crewUri);
                itemView.getContext().startActivity(crewIntent);
            }
        });

    }
}
