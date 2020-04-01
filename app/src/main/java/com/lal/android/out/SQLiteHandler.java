package com.lal.android.out;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class SQLiteHandler extends SQLiteOpenHelper {

//    private static final String TAG = SQLiteHandler.class.getSimpleName();
    String TAG = "dbHelper";
    private static final int DATABASE_VERSION = 3;

    private static final String DATABASE_NAME = "out";

    private static final String TABLE_NAME = "match_list";
    private static final String RUNS = "runs";
    private static final String OVERS = "overs";
    private static final String ID = "id";
    private static final String WICKETS = "wickets";
    private static final String DATE = "date";


    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Insert database on create method");

        String MATCH_LIST = "CREATE TABLE " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY," +
                RUNS + " INTEGER," +
                WICKETS + " INTEGER," +
                DATE + " TEXT," +
                OVERS + " FLOAT" + " );";

        try{
            db.execSQL(MATCH_LIST);
        }
        catch (SQLiteException ex){
            Log.d(TAG,"on create err "+ ex.toString());
        }


        Log.d(TAG, "Database tables created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addMatch(Score score) {
        SQLiteDatabase db = getWritableDatabase();
        float overs = score.getOvers();

        // check is at least one ball
        if(overs > 0){
            ContentValues values = new ContentValues();
            values.put(RUNS, score.getRuns()); // Run
            values.put(OVERS, score.getOvers()); // Overs
            values.put(WICKETS, score.getWickets()); // Wickets
            values.put(DATE, score.getDate()); // Date

            Log.d(TAG, "New match values: "+values);
            try{
                db.insertOrThrow(TABLE_NAME, null, values);
                db.close();
                Log.d(TAG, "New match inserted into sqlite: ");
            }
            catch (SQLiteException ex){
                Log.d(TAG, "New match not inserted into sqlite: " + ex.toString());

            }

        }
        else {
            Log.d(TAG, "Not Inserted");
        }



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
//        Log.d(TAG, "New match fetched from sqlite data ----: " + cursor +"");

        Log.d(TAG, "data number "+DatabaseUtils.dumpCursorToString(cursor));

        for(int i=0; i<cursor.getCount(); i++) {

            Score score_item = new Score(
                cursor.getInt(1),
                cursor.getFloat(4),
                cursor.getInt(2),
                cursor.getLong(3)
            );
            Log.d(TAG, "score: wickets - "+ score_item.getWickets() + ", overs - " + score_item.getOvers() + ", runs - " + score_item.getRuns());

            scoreList.add(score_item);
            cursor.moveToNext();
//            Log.d(TAG, "New match fetched from sqlite: " + score_item.getRuns() +"");

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
