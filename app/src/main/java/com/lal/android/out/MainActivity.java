package com.lal.android.out;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int score = 0;
    int over = 0;
    int balls = 0;
    int fallOfWickets = 0;

    String allOutAnnouncement = "Oh No, All Out !";
    String allOutToastMessage = "All Out, Game Over !";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        TextView outView = (TextView) findViewById(R.id.wicketsTextView);
        outView.setText(String.valueOf(out));
    }


    /**
     * Display the Overs
     *
     * @param over main score
     */
    public void displayOver(int over) {
        TextView overView = (TextView) findViewById(R.id.overTextView);
        overView.setText(String.valueOf(over));
    }

    /**
     * Display the Balls
     *
     * @param balls main score
     */
    public void displayBalls(int balls) {
        TextView ballsView = (TextView) findViewById(R.id.ballsInOverTextView);
        ballsView.setText(String.valueOf(balls));
    }


    /**
     * Display the Score Announcement
     *
     * @param scoreAnnounce main score Announcement
     */
    public void displayScoreAnnounce(String scoreAnnounce) {
        TextView scoreAnnounceView = (TextView) findViewById(R.id.scoreAnnounceTextView);
        scoreAnnounceView.setText(scoreAnnounce);
    }

    /**
     * Display the Score
     *
     * @param score main score
     */
    public void displayScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.scoreTextView);
        scoreView.setText(String.valueOf(score));
    }

    public void openSavedScoreList(View view) {

        // Start the activity connect to the saved score list activity
        // specified class

        Intent ScoreListActivity = new Intent(this, ScoreListActivity.class);
        startActivity(ScoreListActivity);

    }


    }




