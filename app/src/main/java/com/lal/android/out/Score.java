package com.lal.android.out;


/**
 * Created by hp on 16-10-2017.
 */

public class Score {

    private int mRuns;
    private float mOvers;
    private int mWickets;

    public Score(int Runs, float Overs, int Wickets) {
        mRuns = Runs;
        mOvers = Overs;
        mWickets = Wickets;
    }


    public int getRuns() {
        return mRuns;
    }

    public float getOvers() {
        return mOvers;
    }

    public  int getWickets(){ return mWickets;}
}
