package com.lal.android.out;


import android.support.annotation.Nullable;

import java.util.Date;

/**
 * Created by hp on 16-10-2017.
 */

public class Score {

    private int mRuns;
    private float mOvers;
    private int mWickets;
    private long mDate;

    public Score(int Runs, float Overs, int Wickets, Long Date) {
        mRuns = Runs;
        mOvers = Overs;
        mWickets = Wickets;
        mDate = Date;
    }


    public int getRuns() {
        return mRuns;
    }

    public float getOvers() {
        return mOvers;
    }

    public  int getWickets(){
        return mWickets;
    }

    public long getDate(){
        return mDate;
    }
}
