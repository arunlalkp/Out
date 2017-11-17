package com.lal.android.out;


import java.util.ArrayList;
import java.util.concurrent.RunnableScheduledFuture;



/**
 * Created by hp on 16-10-2017.
 */

public class Score {

    private String mRuns;
    private String mOvers;

    public Score(String Runs, String Overs) {
        mRuns = Runs;
        mOvers = Overs;
    }


    public String getRuns() {
        return mRuns;
    }

    public String getOvers() {
        return mOvers;
    }
}
