package com.example.githubsearcher.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.githubsearcher.activity.constants.ApiConstants;

public class SQLExecution extends SQLiteOpenHelper {

    public SQLExecution(final Context context){
        super(context, "githubDB", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ApiConstants.TABLE_NAME + "(" +
                "username VARCHAR(20)" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
