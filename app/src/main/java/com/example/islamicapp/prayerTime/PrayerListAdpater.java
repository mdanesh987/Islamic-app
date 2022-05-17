package com.example.islamicapp.prayerTime;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamicapp.MainActivity;
import com.example.islamicapp.R;
import com.example.islamicapp.homeRecycler.RecyclerViewHolder;
import com.example.islamicapp.homeRecycler.reycler_data;

public class PrayerListAdpater extends RecyclerView.Adapter<PrayerViewHolder>{

    private PrayerModel[] prayerData;

    public PrayerListAdpater(PrayerModel[] prayerData) {
        this.prayerData = prayerData;
    }

    @Override
    public PrayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PrayerViewHolder viewHolder;
        View view = inflater.inflate(R.layout.prayer_list, parent, false);
        viewHolder = new PrayerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( PrayerViewHolder holder, int position) {
        holder.name.setText(prayerData[position].getPrayer_name());
        holder.time.setText(prayerData[position].getPrayer_time());
        holder.leading.setImageResource(prayerData[position].getLeading());
        /*holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*Intent i=new Intent(view.getContext(), MainActivity.class);
                i.putExtra("appbarTitle",prayerData[position].getPrayer_name());
                view.getContext().startActivity(i);*//*
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return prayerData.length;
    }
}
