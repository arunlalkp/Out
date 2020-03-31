package com.lal.android.out;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


public class ScoreListActivity extends AppCompatActivity {

    SQLiteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_list);

        db = new SQLiteHandler(this);

//        db.deleteAllMatch();

        ScoreAdapter adapter = new ScoreAdapter(this, db.getMatch());
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


    }


}
