package com.example.islamicapp.location;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.islamicapp.dashBoard;

public class GeocoderHandler extends Handler {
    @Override
    public void handleMessage(Message message) {
        String locationAddress;
        switch (message.what) {
            case 1:
                Bundle bundle = message.getData();
                locationAddress = bundle.getString("address");
                break;
            default:
                locationAddress = null;
        }
        dashBoard db=new dashBoard();
        db.city.setText(locationAddress);
        //tvAddress.setText(locationAddress);
    }
}
