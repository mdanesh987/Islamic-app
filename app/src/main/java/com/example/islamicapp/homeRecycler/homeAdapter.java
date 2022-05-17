package com.example.islamicapp.homeRecycler;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.islamicapp.MainActivity;
import com.example.islamicapp.prayertime;
import com.example.islamicapp.R;


public class homeAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    public static String TAG="RecyclerView Adapter";
    private reycler_data[] listData;

    public homeAdapter(reycler_data[] listData) {
        Log.d(TAG,"Constructor");
        this.listData=listData;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreateViewHolder");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerViewHolder viewHolder;
        View view = inflater.inflate(R.layout.home_card, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( RecyclerViewHolder holder, int position) {
        holder.title.setText(listData[position].getTitle());
        holder.subtitle.setText(listData[position].getSubtitle());
        holder.leading.setImageResource(listData[position].getLeading());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(position){
                    case 0:
                        Intent i=new Intent(view.getContext(), MainActivity.class);
                        i.putExtra("appbarTitle",listData[position].getTitle());
                        view.getContext().startActivity(i);
                        break;
                    case 1:
                        view.getContext().startActivity(new Intent(view.getContext(), prayertime.class));
                        break;


                }
            }
        });

    }
    @Override
    public int getItemCount() {

        Log.d(TAG,"getItemCount");
        return listData.length;
    }


   /* void startQibla_Activity( View view){
        Intent intent = new Intent(view.getContext(), CompassActivity.class);
        intent.putExtra(Constants.TOOLBAR_TITLE, "My App");		// Toolbar Title
        intent.putExtra(Constants.TOOLBAR_BG_COLOR, "#FFFFFF");		// Toolbar Background color
        intent.putExtra(Constants.TOOLBAR_TITLE_COLOR, "#000000");	// Toolbar Title color
        intent.putExtra(Constants.COMPASS_BG_COLOR, "#FFFFFF");		// Compass background color
        intent.putExtra(Constants.ANGLE_TEXT_COLOR, "#000000");		// Angle Text color
        intent.putExtra(Constants.DRAWABLE_DIAL, R.drawable.dial);	// Your dial drawable resource
        intent.putExtra(Constants.DRAWABLE_QIBLA, R.drawable.qibla); 	// Your qibla indicator drawable resource
        intent.putExtra(Constants.FOOTER_IMAGE_VISIBLE, View.VISIBLE|View.INVISIBLE|View.GONE);	// Footer World Image visibility
        intent.putExtra(Constants.LOCATION_TEXT_VISIBLE, View.VISIBLE|View.INVISIBLE|View.GONE); // Location Text visibility
        view.getContext().startActivity(intent);
    }*/


   /* public homeAdapter(reycler_data[] listData, Context mcontext) {
        Log.d(TAG,"Constructor");
        this.listData=listData;
        this.mcontext=mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreateViewHolder");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerViewHolder viewHolder;
        View view = inflater.inflate(R.layout.home_card, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( RecyclerViewHolder holder, int position) {
        holder.title.setText(listData[position].getTitle());
        holder.subtitle.setText(listData[position].getSubtitle());
        holder.leading.setImageResource(listData[position].getLeading());
        *//*holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("adapter","onclick mathod");
                *//**//*Intent i=new Intent(view.getContext(), OpenDetail.class);
                i.putExtra("verse",listData[position].getVerse());
                i.putExtra("translation",listData[position].getTranslation());
                i.putExtra("number",listData[position].getVerse_no());
                view.getContext().startActivity(i);*//**//*
            }
        });*//*
    }

    @Override
    public int getItemCount() {

        Log.d(TAG,"getItemCount");
        return listData.length;
    }*/
}

