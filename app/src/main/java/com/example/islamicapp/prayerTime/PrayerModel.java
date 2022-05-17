package com.example.islamicapp.prayerTime;

public class PrayerModel {
    private int leading;
    private String prayer_name,prayer_time;

    public PrayerModel(int leading, String prayer_name, String prayer_time) {
        this.leading = leading;
        this.prayer_name = prayer_name;
        this.prayer_time = prayer_time;
    }

    public int getLeading() {
        return leading;
    }

    public void setLeading(int leading) {
        this.leading = leading;
    }

    public String getPrayer_name() {
        return prayer_name;
    }

    public void setPrayer_name(String prayer_name) {
        this.prayer_name = prayer_name;
    }

    public String getPrayer_time() {
        return prayer_time;
    }

    public void setPrayer_time(String prayer_time) {
        this.prayer_time = prayer_time;
    }
}
