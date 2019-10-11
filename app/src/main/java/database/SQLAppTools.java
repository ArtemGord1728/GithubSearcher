package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import models.User;
import constants.ApiConstants;

public class SQLAppTools
{
    private SQLiteDatabase sql_db;

    public SQLAppTools(final Context context) {
        sql_db = new SQLExecution(context).getWritableDatabase();
    }

    public void addToFavorites(User user) {
        ContentValues storeForDB = new ContentValues();
        storeForDB.put("id", user.getId());
        storeForDB.put("username", user.getUsername());
        storeForDB.put("followers", user.getFollowers());
        storeForDB.put("following", user.getFollowing());
        storeForDB.put("stars", user.getStars());
        storeForDB.put("packages", user.getPackages());
        sql_db.insert(String.valueOf(ApiConstants.TABLE_NAME), null, storeForDB);
    }

    public void removeUserFromID(String fieldName, long id){
        sql_db.delete(String.valueOf(ApiConstants.TABLE_NAME), fieldName + " = " + id, null);
    }
}
