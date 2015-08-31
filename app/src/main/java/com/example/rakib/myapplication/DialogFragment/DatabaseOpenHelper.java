package com.example.rakib.myapplication.DialogFragment;


import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by mbiplobe on 8/23/2015.
 */
public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "mibworld.sqlite";
    private static final int DATABASE_VERSION = 1;


    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }
}
