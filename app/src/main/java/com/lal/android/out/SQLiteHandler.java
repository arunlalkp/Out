package com.lal.android.out;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class SQLiteHandler extends SQLiteOpenHelper {
    private static final String TAG = SQLiteHandler.class.getSimpleName();

    private static final int DATABASE_VERSION = 3;

    private static final String DATABASE_NAME = "out";

    private static final String TABLE_NAME = "match_list";
    private static final String RUNS = "runs";
    private static final String OVERS = "overs";
    private static final String ID = "id";

    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String MATCH_LIST = "CREATE TABLE " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY," +
                RUNS + " INTEGER," +
                OVERS + " FLOAT" + " );";
        db.execSQL(MATCH_LIST);

        Log.d(TAG, "Database tables created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addMatch(Score score) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(RUNS, score.getRuns()); // Run
        values.put(OVERS, score.getOvers()); // Overs

        long id = db.insert(TABLE_NAME, null, values);
        db.close();

        Log.d(TAG, "New match inserted into sqlite: " + id);

    }

    public int getCount(){
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor.getCount();
    }

    public ArrayList<Score> getMatch() {

        ArrayList<Score> scoreList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        Log.d(TAG, "New match fetched from sqlite: " + cursor.getCount() +"");
        for(int i=0;i<cursor.getCount();i++) {
            Score score_item = new Score(
                    cursor.getInt(1),
                    cursor.getFloat(2)
            );

            scoreList.add(score_item);
            cursor.moveToNext();
            Log.d(TAG, "New match fetched from sqlite: " + score_item.getRuns() +"");

        }
        cursor.close();
        db.close();

        return scoreList;
    }


    public void deleteAllMatch() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();

    }

    public void deleteMatch(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, RUNS + "=?", new String[]{name});
        db.close();

    }

}
