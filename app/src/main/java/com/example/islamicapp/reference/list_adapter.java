package com.example.islamicapp.reference;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.islamicapp.R;

import java.util.ArrayList;

public class list_adapter implements ListAdapter {

    private final Context context;
    private final ArrayList<refrence_data> ref_data;

    public list_adapter(Context context, ArrayList<refrence_data> ref_data) {
        //super(context, R.layout.reference_list_tile);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.ref_data = ref_data;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return ref_data.size();
    }

    @Override
    public Object getItem(int i) {
        return ref_data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        refrence_data subjectData=ref_data.get(position);
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.reference_list_tile, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            TextView ayat_no=convertView.findViewById(R.id.Ayat_number);
            TextView surah=convertView.findViewById(R.id.Surah_name);
            String ayat=subjectData.getSurah_number()+":"+subjectData.getAyat_number();
            ayat_no.setText(ayat);
            surah.setText(subjectData.getSurah_name());

        }
        return convertView;

    }

    @Override
    public int getItemViewType(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return ref_data.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return true;
    }
}
