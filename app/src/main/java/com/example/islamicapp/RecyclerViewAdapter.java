package com.example.islamicapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamicapp.dbHelper.DataBaseAccess;
import com.example.islamicapp.reference.OpenDetail;
import com.example.islamicapp.reference.refrence_data;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public static String TAG="RecyclerView Adapter";
    ArrayList<refrence_data> ref;
    Context cntxt;
    private ArrayList<MyListData> listData;

    public RecyclerViewAdapter(ArrayList<MyListData> listData,Context cntxt) {
        Log.d(TAG,"Constructor");
        this.listData=listData;
        this.cntxt=cntxt;
    }
    public void get_refrences(int position){
        try{
            DataBaseAccess dao=DataBaseAccess.getInstance(cntxt);
            dao.open();
            ref=dao.getReferences(position+1);
            dao.close();
        }catch(SQLiteException e){
            Log.d("adapter::",e.toString());
        }
                Log.d("adapter::",String.valueOf(ref.get(position).getAyat_id()));
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreateViewHolder");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MyViewHolder viewHolder;
        View view = inflater.inflate(R.layout.list_tile, parent, false);
        viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        holder.number.setText("تعداد:"+listData.get(position).getVerse_no());
        holder.verse.setText(listData.get(position).getVerse());
        holder.translation.setText(listData.get(position).getTranslation());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(view.getContext(), OpenDetail.class);
                i.putExtra("verse", listData.get(position).getVerse());
                i.putExtra("translation", listData.get(position).getTranslation());
                i.putExtra("number", listData.get(position).getVerse_no());
                get_refrences(position);
                i.putParcelableArrayListExtra("refrences",ref);
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {

        Log.d(TAG,"getItemCount");
        return listData.size();
    }
}


