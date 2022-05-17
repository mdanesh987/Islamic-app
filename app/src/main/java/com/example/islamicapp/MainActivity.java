package com.example.islamicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.islamicapp.dbHelper.DataBaseAccess;
import com.example.islamicapp.reference.refrence_data;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MaterialToolbar appbar;
    ArrayList<MyListData> data;
    MyListData[] myListData = new MyListData[] {
            new MyListData("آیت:1","تَجْرِي مِن تَحْتِهَا الأَنْهَار۞" ,"جنتیں باغات(ہہں)ان باغوں کے نیچے سے نہریں"),
            new MyListData("آیت:2","تَجْرِي مِن تَحْتِهَا الأَنْهَار۞" ,"جنتیں باغات(ہہں)ان باغوں کے نیچے سے نہریں"),
            new MyListData("آیت:3","تَجْرِي مِن تَحْتِهَا الأَنْهَار۞" ,"جنتیں باغات(ہہں)ان باغوں کے نیچے سے نہریں"),
            new MyListData("آیت:4","تَجْرِي مِن تَحْتِهَا الأَنْهَار۞" ,"جنتیں باغات(ہہں)ان باغوں کے نیچے سے نہریں"),
            new MyListData("آیت:5","تَجْرِي مِن تَحْتِهَا الأَنْهَار۞" ,"جنتیں باغات(ہہں)ان باغوں کے نیچے سے نہریں"),
            new MyListData("آیت:6","تَجْرِي مِن تَحْتِهَا الأَنْهَار۞" ,"جنتیں باغات(ہہں)ان باغوں کے نیچے سے نہریں"),
            new MyListData("آیت:7","تَجْرِي مِن تَحْتِهَا الأَنْهَار۞" ,"جنتیں باغات(ہہں)ان باغوں کے نیچے سے نہریں"),
            new MyListData("آیت81","تَجْرِي مِن تَحْتِهَا الأَنْهَار۞" ,"جنتیں باغات(ہہں)ان باغوں کے نیچے سے نہریں"),
            new MyListData("آیت:9","تَجْرِي مِن تَحْتِهَا الأَنْهَار۞" ,"جنتیں باغات(ہہں)ان باغوں کے نیچے سے نہریں"),
            new MyListData("آیت:10","تَجْرِي مِن تَحْتِهَا الأَنْهَار۞" ,"جنتیں باغات(ہہں)ان باغوں کے نیچے سے نہریں"),
            new MyListData("آیت:11","تَجْرِي مِن تَحْتِهَا الأَنْهَار۞" ,"جنتیں باغات(ہہں)ان باغوں کے نیچے سے نہریں"),
            new MyListData("آیت:12","تَجْرِي مِن تَحْتِهَا الأَنْهَار۞" ,"جنتیں باغات(ہہں)ان باغوں کے نیچے سے نہریں"),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivty","Oncreate Called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appbar=findViewById(R.id.topAppBar);


        if(getIntent().hasExtra("appbarTitle")){
            String title=getIntent().getStringExtra("appbarTitle");
            appbar.setTitle(title);
        }
        appbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        try {
            DataBaseAccess dao = DataBaseAccess.getInstance(getApplicationContext());
            dao.open();

            data = dao.getQuotes();

            dao.close();
        }catch(SQLiteCantOpenDatabaseException e){
            Log.d("database_exception::",e.toString());
        }
        Log.d("MainActivity::", data.get(1).getVerse_no());

        //ArrayList<refrence_data> refrence_data=dao.getReferences();

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recyclerview);

        RecyclerViewAdapter adapter=new RecyclerViewAdapter(data,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        recyclerView.setAdapter(adapter);



    }
}