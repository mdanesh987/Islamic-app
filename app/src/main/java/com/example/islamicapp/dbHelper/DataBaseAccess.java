package com.example.islamicapp.dbHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.islamicapp.MyListData;
import com.example.islamicapp.reference.refrence_data;

import java.util.ArrayList;

public class DataBaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DataBaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DataBaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DataBaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DataBaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public ArrayList<MyListData> getQuotes() {
        ArrayList<MyListData> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM ayat", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new MyListData(cursor.getString(1),cursor.getString(2),cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public ArrayList<refrence_data> getReferences(int ayat_id) {
        ArrayList<refrence_data> list = new ArrayList<>();
        final String MY_QUERY = "SELECT ref.* FROM ayat INNER JOIN ayat_references ref on ayat.id = ref.ayat_id where ayat.id = " + ayat_id + ";";
        Cursor cursor = database.rawQuery(MY_QUERY,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new refrence_data(cursor.getInt(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4) ));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}

