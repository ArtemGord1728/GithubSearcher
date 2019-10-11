package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import constants.ApiConstants;

public class SQLExecution extends SQLiteOpenHelper {

    public SQLExecution(final Context context){
        super(context, "githubDB", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ApiConstants.TABLE_NAME + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username VARCHAR(20)," +
                "followers INTEGER," +
                "following INTEGER" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
