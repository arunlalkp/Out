package com.lal.android.out;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int score = 0;
    int over = 0;
    int balls = 0;
    public int fallOfWickets = 0;

    int previousOver;
    int previousBalls;
    int previousScore;
    int previousFallOfWicket;
    String previousAnnouncement;

    String allOutAnnouncement = "Oh No, All Out !";
    String allOutToastMessage = "All Out, Game Over !";

    SQLiteHandler db;

    TextView outView, overView, ballsView, scoreAnnounceView, scoreView;

    String TAG = "ActivityOne";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new SQLiteHandler(this);

        outView = (TextView) findViewById(R.id.wicketsTextView);
        overView = (TextView) findViewById(R.id.overTextView);
        ballsView = (TextView) findViewById(R.id.ballsInOverTextView);
        scoreAnnounceView = (TextView) findViewById(R.id.scoreAnnounceTextView);
        scoreView = (TextView) findViewById(R.id.scoreTextView);

        Log.i(TAG, "----------ON CREATE-------------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "----------ON START-------------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "----------ON RESUME-------------");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "----------ON PAUSE-------------");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "----------ON STOP-------------");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "----------ON DESTROY-------------");

    }

    /**
     * Perform when SIX button is Clicked
     * add six runs to Score
     *
     * @param V view
     */

    public void addSixRuns(View V) {

        if (fallOfWickets == 10) {
            displayScoreAnnounce(allOutAnnouncement);
            Toast.makeText(MainActivity.this, allOutToastMessage, Toast.LENGTH_SHORT).show();
            return;
        }
        updatePreviousValues(score, balls, over, "What a SIX !", fallOfWickets);
        score = score + 6;
        balls = balls + 1;

        displayScore(score);
        displayBalls(balls);
        displayOver(over);
        displayScoreAnnounce("What a SIX !");

        if (balls == 6) {
            balls = 0;
            displayBalls(balls);
            over = over + 1;
            displayOver(over);
        }
    }


    /**
     * Perform when FOUR button is Clicked
     * add four runs to Score
     *
     * @param V view
     */
    public void addFourRuns(View V) {

        if (fallOfWickets == 10) {
            displayScoreAnnounce(allOutAnnouncement);
            Toast.makeText(MainActivity.this, allOutToastMessage, Toast.LENGTH_SHORT).show();
            return;
        }

        updatePreviousValues(score, balls, over, "That is a FOUR !", fallOfWickets);

        score = score + 4;
        balls = balls + 1;
        displayScore(score);
        displayBalls(balls);
        displayOver(over);
        displayScoreAnnounce("That is a FOUR !");

        if (balls == 6) {
            balls = 0;
            displayBalls(balls);
            over = over + 1;
            displayOver(over);
        }
    }

    /**
     * Perform when TRIPLE button is Clicked
     * add 3 runs to Score
     *
     * @param V view
     */
    public void addThreeRuns(View V) {

        if (fallOfWickets == 10) {
            displayScoreAnnounce(allOutAnnouncement);
            Toast.makeText(MainActivity.this, allOutToastMessage, Toast.LENGTH_SHORT).show();
            return;
        }
        updatePreviousValues(score, balls, over, "Good Running Between wickets !", fallOfWickets);

        score = score + 3;
        balls = balls + 1;
        displayScore(score);
        displayBalls(balls);
        displayOver(over);
        displayScoreAnnounce("Good Running Between wickets !");

        if (balls == 6) {
            balls = 0;
            displayBalls(balls);
            over = over + 1;
            displayOver(over);
        }
    }

    /**
     * Perform when TWO button is Clicked
     * add 2 runs to Score
     *
     * @param V view
     */
    public void addTwoRuns(View V) {

        if (fallOfWickets == 10) {
            displayScoreAnnounce(allOutAnnouncement);
            Toast.makeText(MainActivity.this, allOutToastMessage, Toast.LENGTH_SHORT).show();
            return;
        }

        updatePreviousValues(score, balls, over, "Nice Double !", fallOfWickets);

        score = score + 2;
        balls = balls + 1;
        displayScore(score);
        displayBalls(balls);
        displayOver(over);
        displayScoreAnnounce("Nice Double !");

        if (balls == 6) {
            balls = 0;
            displayBalls(balls);
            over = over + 1;
            displayOver(over);
        }
    }

    /**
     * Perform when ONE button is Clicked
     * add 1 runs to Score
     *
     * @param V view
     */
    public void addOneRuns(View V) {

        if (fallOfWickets == 10) {
            displayScoreAnnounce(allOutAnnouncement);
            Toast.makeText(MainActivity.this, allOutToastMessage, Toast.LENGTH_SHORT).show();
            return;
        }
        updatePreviousValues(score, balls, over, "Just a Single !", fallOfWickets);

        score = score + 1;
        balls = balls + 1;
        displayScore(score);
        displayBalls(balls);
        displayOver(over);
        displayScoreAnnounce("Just a Single !");

        if (balls == 6) {
            balls = 0;
            displayBalls(balls);
            over = over + 1;
            displayOver(over);
        }
    }

    /**
     * Perform when WIDE/NO BALL button is Clicked
     * add 1 runs to Score
     *
     * @param V view
     */
    public void addOneRunsExtra(View V) {

        if (fallOfWickets == 10) {
            displayScoreAnnounce(allOutAnnouncement);
            Toast.makeText(MainActivity.this, allOutToastMessage, Toast.LENGTH_SHORT).show();
            return;
        }
        updatePreviousValues(score, balls, over, "Got an Extra Run !", fallOfWickets);

        score = score + 1;
        displayScore(score);
        displayBalls(balls);
        displayOver(over);
        displayScoreAnnounce("Got an Extra Run !");
    }


    /**
     * perform when OUT Button is clicked
     *
     * @param V view the out text view
     */
    public void addOneToOutTextView(View V) {

        if (fallOfWickets == 10) {
            displayScoreAnnounce(allOutAnnouncement);
            Toast.makeText(MainActivity.this, allOutToastMessage, Toast.LENGTH_SHORT).show();
            return;
        }

        updatePreviousValues(score, balls, over, "Oh No, " + fallOfWickets + " Wicket is gone", fallOfWickets);


        fallOfWickets = fallOfWickets + 1;
        balls = balls + 1;
        displayOut(fallOfWickets);
        displayBalls(balls);
        displayScoreAnnounce("Oh No, " + fallOfWickets + " Wicket is gone");

        if (balls == 6) {
            balls = 0;
            displayBalls(balls);
            over = over + 1;
            displayOver(over);
        }

    }

    /**
     * Perform when DEAD BALL / BACK is Clicked
     * go back to previous Scoreboard
     *
     * @param V view
     */
    public void goToPreviousValues(View V){
        displayPreviousValues(previousScore, previousBalls, previousOver, previousAnnouncement, previousFallOfWicket);
    }



    /**
     * Perform when DOT BALL button is Clicked
     * add 1 runs to Score without add balls
     *
     * @param V view
     */
    public void addDotBall(View V) {

        if (fallOfWickets == 10) {
            displayScoreAnnounce(allOutAnnouncement);
            Toast.makeText(MainActivity.this, allOutToastMessage, Toast.LENGTH_SHORT).show();
            return;
        }
        updatePreviousValues(score, balls, over, "Dot Ball !!", fallOfWickets);
        balls = balls + 1;
        displayBalls(balls);
        displayOver(over);
        displayScoreAnnounce("Dot Ball !!");

        if (balls == 6) {
            balls = 0;
            displayBalls(balls);
            over = over + 1;
            displayOver(over);
        }
    }


    /**
     * when the RESET Button is pressed
     * Reset the whole game
     *
     * @param V Reset all the Views
     */
    public void resetGame(View V) {

        new AlertDialog.Builder(this)
                .setTitle("Reset")
                .setMessage("Are you sure want to Reset score?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        score = 0;
                        over = 0;
                        balls = 0;
                        fallOfWickets = 0;

                        displayScore(score);
                        displayOver(over);
                        displayBalls(balls);
                        displayOut(fallOfWickets);
                        displayScoreAnnounce("Come, Lets Start The Game !!");
                        Toast.makeText(MainActivity.this, "Score Reseted", Toast.LENGTH_SHORT).show();

                    }

                })
                .setNegativeButton("No", null).show();
    }

    /**
     * Display Out
     *
     * @param out main score
     */
    public void displayOut(int out) {
        outView.setText(String.valueOf(out));
    }


    /**
     * Display the Overs
     *
     * @param over main score
     */
    public void displayOver(int over) {
        overView.setText(String.valueOf(over));
    }

    /**
     * Display the Balls
     *
     * @param balls main score
     */
    public void displayBalls(int balls) {
        ballsView.setText(String.valueOf(balls));
    }


    /**
     * Display the Score Announcement
     *
     * @param scoreAnnounce main score Announcement
     */
    public void displayScoreAnnounce(String scoreAnnounce) {
        scoreAnnounceView.setText(scoreAnnounce);
    }

    /**
     * Display the Score
     *
     * @param score main score
     */
    public void displayScore(int score) {
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display the Values
     *
     * @param score main score
     * @param balls balls
     * @param over over
     * @param announcement announcement
     * @param fallOfWickets fallOfWickets
     */
    private void displayPreviousValues(int score, int balls, int over, String announcement, int fallOfWickets) {
        this.score = score;
        this.balls = balls;
        this.over = over;
        this.fallOfWickets = fallOfWickets;
        scoreView.setText(String.valueOf(score));
        ballsView.setText(String.valueOf(balls));
        overView.setText(String.valueOf(over));
        scoreAnnounceView.setText(announcement);
        outView.setText(String.valueOf(fallOfWickets));

    }

    /**
     * Update previous Scoreboard values
     *
     */
    public void updatePreviousValues(int score, int balls, int over, String announcement, int fallOfWickets){

        previousScore = score;
        previousBalls = balls;
        previousOver = over;
        previousAnnouncement = announcement;
        previousFallOfWicket = fallOfWickets;

    }

    public  void saveScore(View view){
//        Log.d("SaveScore", "Inside saveScore");
        String oversStr = over + "." + balls;
        Float overs = Float.parseFloat(oversStr);
        Score s = new Score(this.score, overs, this.fallOfWickets,System.currentTimeMillis());
        db.addMatch(s);
        Toast.makeText(MainActivity.this, "Match Saved", Toast.LENGTH_LONG).show();

    }

    public void openSavedScoreList(View view) {

        // Start the activity connect to the saved score list activity
        // specified class
        String oversStr = over + "." + balls;
        Float overs = Float.parseFloat(oversStr);
        Score s = new Score(this.score, overs, this.fallOfWickets, System.currentTimeMillis());
        db.addMatch(s);
        Intent ScoreListActivity = new Intent(this, ScoreListActivity.class);
        startActivity(ScoreListActivity);

    }

}




