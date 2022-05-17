package com.example.islamicapp.reference;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import com.example.islamicapp.R;
import com.example.islamicapp.homeRecycler.reycler_data;

import java.util.ArrayList;

public class OpenDetail extends Activity {
    ListView reference_list;
    TextView Verse,Translation,Verse_no;
    AppCompatImageButton share;

    ArrayList<refrence_data> ref_list=new ArrayList<refrence_data>();





    //ArrayList<refrence_data> ref=null;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_detail);

       /* ref_list.add(new refrence_data(1,"Al-An'am (The Cattle) ",6,34));
        ref_list.add(new refrence_data(1,"Al-A'raf (The Heights) ",6,34));
        ref_list.add(new refrence_data(1,"Yunus ",6,34));
        ref_list.add(new refrence_data(1,"Al-Fatiha (The Opening) ",6,34));
        ref_list.add(new refrence_data(1,"Al-Fatiha (The Opening) ",6,34));
        ref_list.add(new refrence_data(1,"Al-Fatiha (The Opening) ",6,34));
        ref_list.add(new refrence_data(1,"Al-Fatiha (The Opening) ",6,34));
        ref_list.add(new refrence_data(1,"Al-Fatiha (The Opening) ",6,34));
        ref_list.add(new refrence_data(1,"Al-Fatiha (The Opening) ",6,34));
        ref_list.add(new refrence_data(1,"Al-Fatiha (The Opening) ",6,34));
        ref_list.add(new refrence_data(1,"Al-Fatiha (The Opening) ",6,34));*/


        Verse=findViewById(R.id.ayayt);
        Translation=findViewById(R.id.translation);
        Verse_no=findViewById(R.id.verse_no);
        share=findViewById(R.id.share);









        /*share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        getInents();

    }

    private void getInents(){
        if(getIntent().hasExtra("verse")&&getIntent().hasExtra("translation")&&getIntent().hasExtra("number")&&getIntent().hasExtra("refrences")){
            String verse=getIntent().getStringExtra("verse");
            String translation=getIntent().getStringExtra("translation");
            String number=getIntent().getStringExtra("number");
            ref_list=getIntent().getParcelableArrayListExtra("refrences");
            setData(verse,translation,number);
        }
        else{
            Toast.makeText(this,"Contet Missing",Toast.LENGTH_SHORT).show();
        }

    }

    private void setData(String ayat,String translation,String number){
        Verse_no.setText("تعداد:"+number);
        Verse.setText(ayat);
        Translation.setText(translation);

        list_adapter adapter = new list_adapter(OpenDetail.this,ref_list);
        reference_list=(ListView)findViewById(R.id.references);
        reference_list.setAdapter(adapter);
    }
}
