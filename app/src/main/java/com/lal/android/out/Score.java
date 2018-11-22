package com.lal.android.out;


/**
 * Created by hp on 16-10-2017.
 */

public class Score {

    private int mRuns;
    private float mOvers;

    public Score(int Runs, float Overs) {
        mRuns = Runs;
        mOvers = Overs;
    }


    public int getRuns() {
        return mRuns;
    }

    public float getOvers() {
        return mOvers;
    }
}
