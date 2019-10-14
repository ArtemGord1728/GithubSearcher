package com.example.githubsearcher.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.githubsearcher.activity.constants.ApiConstants;
import com.example.githubsearcher.models.User;

import java.util.ArrayList;
import java.util.List;

public class SQLAppTools {

    private SQLiteDatabase sql_db;

    public SQLAppTools(final Context context) {
        sql_db = new SQLExecution(context).getWritableDatabase();
    }

    public void addToFavorites(User user) {
        ContentValues storeForDB = new ContentValues();
        storeForDB.put("username", user.getLogin());
        sql_db.insert(String.valueOf(ApiConstants.TABLE_NAME), null, storeForDB);
    }

    public void removeUserFromID(String fieldName, long id){
        sql_db.delete(String.valueOf(ApiConstants.TABLE_NAME), fieldName + " = " + id, null);
    }

    public List<User> getAllFavorite() {
        final Cursor cursor = sql_db.query(String.valueOf(ApiConstants.TABLE_NAME), null, null, null, null, null, "username DESC");
        List<User> users = new ArrayList<>();

        if(cursor.moveToFirst()){
            while(cursor.moveToNext())
            {
                users.add(new User(
                        cursor.getString(cursor.getColumnIndex("username"))));
            }
        }
        cursor.close();
        return users;
    }
}
