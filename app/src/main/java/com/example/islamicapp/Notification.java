package com.example.islamicapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.batoulapps.adhan.CalculationMethod;
import com.batoulapps.adhan.CalculationParameters;
import com.batoulapps.adhan.Coordinates;
import com.batoulapps.adhan.Madhab;
import com.batoulapps.adhan.PrayerTimes;
import com.batoulapps.adhan.data.DateComponents;
import com.example.islamicapp.location.AppLocationService;
import com.google.android.material.appbar.MaterialToolbar;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class Notification extends AppCompatActivity {
    MaterialToolbar appbar;
    LocationManager locationManager;
    double latitude, longitude;
    private static final int REQUEST_LOCATION = 1;
    String city,country,state;
    AppLocationService appLocationService=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        appbar = findViewById(R.id.noti_appbar);
        //appLocationService=new AppLocationService(getApplicationContext());
        //locationManager = (LocationManager)  this.getSystemService(Context.LOCATION_SERVICE);
        appbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });





        CalculationParameters params =
                CalculationMethod.MUSLIM_WORLD_LEAGUE.getParameters();
        params.madhab = Madhab.HANAFI;
        params.adjustments.fajr = 2;


        DateComponents date = DateComponents.from(new Date());
        Coordinates coordinates = new Coordinates(latitude, longitude);
        PrayerTimes prayerTimes = new PrayerTimes(coordinates, date, params);

        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone("Pakistan/Islamabad"));
        //formatter.format(prayerTimes.fajr);

        Log.d("Prayer Times::",formatter.format(prayerTimes.fajr));
        Log.d("Prayer Times::",formatter.format(prayerTimes.dhuhr));
        Log.d("Prayer Times::",formatter.format(prayerTimes.asr));
        Log.d("Prayer Times::",formatter.format(prayerTimes.maghrib));
        Log.d("Prayer Times::",formatter.format(prayerTimes.isha));
        //Log.d("Prayer Times::",city.concat(country));
        //Log.d("Prayer Times::",formatter.format(prayerTimes.isha));
    }


    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                getApplicationContext());
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        getApplicationContext().startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }
}