package com.example.islamicapp.prayerTime;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamicapp.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;

public class PrayerViewHolder extends RecyclerView.ViewHolder {

    public ImageView leading;
    public TextView name;
    public Chip time;
    public View layout;


    public PrayerViewHolder( View itemView) {
        super(itemView);
        this.name = (TextView) itemView.findViewById(R.id.p_name);
        this.time = (Chip) itemView.findViewById(R.id.time);
        this.leading = (ImageView) itemView.findViewById(R.id.p_leading_icon);
        this.layout=(MaterialCardView) itemView.findViewById(R.id.p_card);

    }
}
