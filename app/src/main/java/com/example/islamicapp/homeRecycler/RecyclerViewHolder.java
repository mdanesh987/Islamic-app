package com.example.islamicapp.homeRecycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.islamicapp.R;
import com.google.android.material.card.MaterialCardView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    //public RecyclerViewAdapter.OnItemClickListener listener;
    public TextView title;
    public TextView subtitle;
    public ImageView leading;
    public MaterialCardView layout;


    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.title = (TextView) itemView.findViewById(R.id.title);
        this.subtitle = (TextView) itemView.findViewById(R.id.subtitle);
        this.leading = (ImageView) itemView.findViewById(R.id.leading_icon);
        this.layout=(MaterialCardView) itemView.findViewById(R.id.home_card);
       // itemView.setOnClickListener(this);
    }
}


