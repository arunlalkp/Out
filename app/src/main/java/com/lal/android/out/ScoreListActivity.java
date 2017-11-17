package com.lal.android.out;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
//import static com.lal.android.out.R.id.rootView;

public class ScoreListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_list);


        ArrayList<Score> scoreList = new ArrayList<Score>();

        scoreList.add(new Score("87 Runs","in 5.4 Overs"));
        scoreList.add(new Score("112 Runs","in .8.5 Overs"));
        scoreList.add(new Score("12 Runs","in 3 Overs"));
        scoreList.add(new Score("56 Runs","in 5 Overs"));
        scoreList.add(new Score("76 Runs","in 7 Overs"));
        scoreList.add(new Score("100 Runs","in 10 Overs"));
        scoreList.add(new Score("99 Runs","in 9 Overs"));
        scoreList.add(new Score("23 Runs","in 3.5 Overs"));
        scoreList.add(new Score("44 Runs","in 5 Overs"));
        scoreList.add(new Score("50 Runs","in 5 Overs"));
        scoreList.add(new Score("178 Runs","in 10.3 Overs"));
        scoreList.add(new Score("21 Runs","in 7 Overs"));
        scoreList.add(new Score("11 Runs","in 3.2 Overs"));


       // LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView) ;

//        for(int index = 0; index < scoreList.size(); index++) {
//
//            TextView scoreView = new TextView(this);
//            scoreView.setText(scoreList.get(index));
//            rootView.addView(scoreView);
//        };

        ScoreAdapter adapter = new ScoreAdapter(this, scoreList);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);


    }


}
