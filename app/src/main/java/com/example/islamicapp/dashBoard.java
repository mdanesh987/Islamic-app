package com.example.islamicapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamicapp.homeRecycler.homeAdapter;
import com.example.islamicapp.homeRecycler.reycler_data;
import com.example.islamicapp.location.GeocoderHandler;
import com.example.islamicapp.location.LocationAddress;
import com.google.android.material.chip.Chip;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class dashBoard extends Activity implements LocationListener {
    ImageButton notify;

    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;
    public Chip city;
    List<Address> addresses = null;

    LocationManager locationManager = null;

    double latitude, longitude;

    Geocoder geocoder;

    private static final int REQUEST_LOCATION = 1;
    private static final String TAG = "dashBoard";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        notify=findViewById(R.id.notification);
        city=findViewById(R.id.city_name);
        dateTimeDisplay=findViewById(R.id.date);

        calendar = Calendar.getInstance();

        dateFormat = new SimpleDateFormat("EEE d,MMM yyyy");
        date = dateFormat.format(calendar.getTime());
        dateTimeDisplay.setText(date);


        locationManager = (LocationManager)  this.getSystemService(Context.LOCATION_SERVICE);

        //getLocation();


        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Notification.class));
            }
        });


        reycler_data[] myListData = new reycler_data[] {
                new reycler_data(R.drawable.quran,"Al-Quran","Learn all the Surahs "),
                new reycler_data(R.drawable.prayer,"Prayer Times","Get the prayer timing "),
                new reycler_data(R.drawable.qibla,"Qibla Direction","Learn how to pray "),
                new reycler_data(R.drawable.qibla,"Nearby","Find the closest mosque"),
                new reycler_data(R.drawable.calender,"Calender","Important islamic events "),
                new reycler_data(R.drawable.qibla,"Qibla Direction","Learn how to pray "),
        };

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.home_recycler);

        homeAdapter myRecyclerAdapter = new homeAdapter(myListData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(myRecyclerAdapter);
    }


    /*void getLocation(){
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

            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location!=null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();

                String[] address=getAddressFromLocation(latitude, longitude,
                        getApplicationContext());
                Log.d("Location:::",address[1]);
                city.setText(address[1]);
                Toast.makeText(this,address[1],Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"Unable to get location",Toast.LENGTH_SHORT).show();
            }

        }else{
            //locationManager = (LocationManager)  this.getSystemService(Context.LOCATION_SERVICE);
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location!=null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();

                String[] address=getAddressFromLocation(latitude, longitude,
                        getApplicationContext());
                Log.d("Location:::",address[1]);
                city.setText(address[1]);
                Toast.makeText(this,address[1],Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"Unable to get location",Toast.LENGTH_SHORT).show();
            }
        }
    }*/



   /* public  String[] getAddressFromLocation(final double latitude, final double longitude,
                                                final Context context) {
        final String[] result = {null};
        Thread thread = new Thread() {


            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());

                try {
                    List<Address> addressList = geocoder.getFromLocation(
                            latitude, longitude, 1);
                    if (addressList != null && addressList.size() > 0) {
                        Address address = addressList.get(0);
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                            sb.append(address.getAddressLine(i)).append("\n");
                        }
                        sb.append(address.getLocality()).append(",");
                        //sb.append(address.getPostalCode()).append("\n");
                        sb.append(address.getCountryName());
                        //result[0] = sb.toString();

                    }
                } catch (IOException e) {
                    Log.e(TAG, "Unable connect to Geocoder", e);
                } *//*finally {
                    Message message = Message.obtain();
                    message.setTarget(handler);
                    if (result != null) {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        result = "Latitude: " + latitude + " Longitude: " + longitude +
                                "\n\nAddress:\n" + result;
                        bundle.putString("address", result);
                        message.setData(bundle);
                    } else {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        result = "Latitude: " + latitude + " Longitude: " + longitude +
                                "\n Unable to get address for this lat-long.";
                        bundle.putString("address", result);
                        message.setData(bundle);
                    }
                    message.sendToTarget();
                }*//*
            }
        };
        thread.start();
        return result;
    }*/

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }

    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {

    }

    @Override
    public void onFlushComplete(int requestCode) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
}
