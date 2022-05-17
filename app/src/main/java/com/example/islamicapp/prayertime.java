package com.example.islamicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.batoulapps.adhan.CalculationMethod;
import com.batoulapps.adhan.CalculationParameters;
import com.batoulapps.adhan.Coordinates;
import com.batoulapps.adhan.Madhab;
import com.batoulapps.adhan.data.DateComponents;
import com.example.islamicapp.homeRecycler.reycler_data;
import com.example.islamicapp.prayerTime.PrayerListAdpater;
import com.example.islamicapp.prayerTime.PrayerModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class prayertime extends AppCompatActivity {
    PrayerModel[] prayer_data;
    RecyclerView prayer_list;
    LocationManager locationManager = null;


    double latitude, longitude;
    private static final int REQUEST_LOCATION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_times);

        getLocation();

        CalculationParameters params =
                CalculationMethod.MUSLIM_WORLD_LEAGUE.getParameters();
        params.madhab = Madhab.HANAFI;
        params.adjustments.fajr = 2;

        DateComponents date = DateComponents.from(new Date());

        Coordinates coordinates = new Coordinates(latitude, longitude);

        com.batoulapps.adhan.PrayerTimes prayerTimes = new com.batoulapps.adhan.PrayerTimes(coordinates, date, params);

        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone("Pakistan/Islamabad"));
        //formatter.format(prayerTimes.fajr);

        Log.d("Prayer Times::",formatter.format(prayerTimes.fajr));
        Log.d("Prayer Times::",formatter.format(prayerTimes.dhuhr));
        Log.d("Prayer Times::",formatter.format(prayerTimes.asr));
        Log.d("Prayer Times::",formatter.format(prayerTimes.maghrib));
        Log.d("Prayer Times::",formatter.format(prayerTimes.isha));

        prayer_data= new PrayerModel[] {
                new PrayerModel(R.drawable.sunrise,"fajr",formatter.format(prayerTimes.fajr)),
                new PrayerModel(R.drawable.sun,"dohr",formatter.format(prayerTimes.dhuhr)),
                new PrayerModel(R.drawable.sunset,"asr",formatter.format(prayerTimes.asr)),
                new PrayerModel(R.drawable.moonrise,"maghrib",formatter.format(prayerTimes.maghrib)),
                new PrayerModel(R.drawable.moon,"isha",formatter.format(prayerTimes.isha))
        };



        prayer_list=(RecyclerView) findViewById(R.id.prayer_list);

        PrayerListAdpater adapter=new PrayerListAdpater(prayer_data);
        prayer_list.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        prayer_list.setAdapter(adapter);
    }
    void getLocation(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            //return;
        }else {
            locationManager = (LocationManager)  this.getSystemService(Context.LOCATION_SERVICE);
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location!=null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            }
            /*else{
                Toast.makeText(this,"Unable to get location",Toast.LENGTH_SHORT).show();
            }*/
        }
    }
}