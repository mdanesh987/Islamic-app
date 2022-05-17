package com.example.islamicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.islamicapp.homeRecycler.homeAdapter;
import com.example.islamicapp.homeRecycler.reycler_data;

public class Home extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("HomeACtivty","Oncreate Called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }

}



