package com.example.islamicapp;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    //public RecyclerViewAdapter.OnItemClickListener listener;
    public TextView number;
    public TextView verse;
    public TextView translation;
    public MaterialCardView layout;

    public MyViewHolder( View itemView) {
        super(itemView);
        this.number = (TextView) itemView.findViewById(R.id.verse_no);
        this.verse = (TextView) itemView.findViewById(R.id.ayayt);
        this.translation = (TextView) itemView.findViewById(R.id.translation);
        this.layout=(MaterialCardView) itemView.findViewById(R.id.g_card);
       // itemView.setOnClickListener(this);
    }
}


