package com.lal.android.out;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hp on 16-10-2017.
 */

public class ScoreAdapter extends ArrayAdapter<Score> {

    public ScoreAdapter(Activity context, ArrayList<Score> Score) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, Score);}

        //@NonNull
        //@Override
        public View getView ( int position, View convertView, ViewGroup parent){
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item, parent, false);
            }

            // Get the {@link AndroidFlavor} object located at this position in the list
            Score currentScore = getItem(position);

            // Find the TextView in the list_item.xml layout with the ID version_name
            TextView runsTextView = (TextView) listItemView.findViewById(R.id.runs_text_view);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            runsTextView.setText(currentScore.getRuns()+"/" + currentScore.getWickets());

            // Find the TextView in the list_item.xml layout with the ID version_number
            TextView numberTextView = (TextView) listItemView.findViewById(R.id.overs_tet_view);
            // Get the version number from the current AndroidFlavor object and
            // set this text on the number TextView
            numberTextView.setText("in " + currentScore.getOvers() + " Overs");

            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView
            return listItemView;
        }
    }
