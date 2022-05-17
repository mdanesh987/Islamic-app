package com.example.islamicapp.reference;

import android.os.Parcel;
import android.os.Parcelable;

public class refrence_data implements Parcelable {
    int ayat_number;
    String surah_name;
    int ayat_id,surah_number;
    protected refrence_data(Parcel in) {
        ayat_number = in.readInt();
        ayat_id = in.readInt();
        surah_number = in.readInt();
        surah_name = in.readString();
    }

    public void setAyat_number(int ayat_number) {
        this.ayat_number = ayat_number;
    }

    public int getAyat_id() {
        return ayat_id;
    }

    public void setAyat_id(int ayat_id) {
        this.ayat_id = ayat_id;
    }

    public int getSurah_number() {
        return surah_number;
    }

    public void setSurah_number(int surah_number) {
        this.surah_number = surah_number;
    }

    public static final Creator<refrence_data> CREATOR = new Creator<refrence_data>() {
        @Override
        public refrence_data createFromParcel(Parcel in) {
            return new refrence_data(in);
        }

        @Override
        public refrence_data[] newArray(int size) {
            return new refrence_data[size];
        }
    };

    public int getAyat_number() {
        return ayat_number;
    }

    public String getSurah_name() {
        return surah_name;
    }

    public void setSurah_name(String surah_name) {
        this.surah_name = surah_name;
    }

    public refrence_data(int ayat_id, String surah_name, int surah_number,int ayat_number) {
        this.ayat_number = ayat_number;
        this.surah_name = surah_name;
        this.ayat_id = ayat_id;
        this.surah_number = surah_number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ayat_number);
        parcel.writeInt(surah_number);
        parcel.writeInt(ayat_id);
        parcel.writeString(surah_name);
    }


    }

