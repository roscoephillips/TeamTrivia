package com.example.android.teamtrivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

public class MainActivity extends AppCompatActivity {

    //Global variables

    EditText nameOfTeamA, nameOfTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameOfTeamA = (EditText) findViewById(R.id.team_a_name);
        nameOfTeamB = (EditText) findViewById(R.id.team_b_name);
    }

    /**
     * This declares/initializes team A's default score value.
     */

    int teamAScore = 0;

    /**
     * This will give Team A 10 points for an easy question.
     */

    public void teamA10Pts(View view) {
        teamAScore = teamAScore + 10;
        displayForTeamA(teamAScore);
    }
    /**
     * This will give Team A 30 points for a moderately challenging question.
     */

    public void teamA30Pts(View view) {
        teamAScore = teamAScore + 30;
        displayForTeamA(teamAScore);
    }
    /**
     * This will give Team A 50 points for a hard question.
     */

    public void teamA50Pts(View view) {
        teamAScore = teamAScore + 50;
        displayForTeamA(teamAScore);
    }
    /**
     * Team A will be penalized 10 points.
     */

    public void teamAMiss(View view) {
        teamAScore = teamAScore - 10;
        displayForTeamA(teamAScore);
    }

    /**
     * Displays the given score for Team A.
     */

    private void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This declares/initializes team B's default score value.
     */

    int teamBScore = 0;

    /**
     * This will give Team B 10 points for an easy question.
     */

    public void teamB10Pts(View view) {
        teamBScore = teamBScore + 10;
        displayForTeamB(teamBScore);
    }
    /**
     * This will give Team B 30 points for a moderately challenging question.
     */

    public void teamB30Pts(View view) {
        teamBScore = teamBScore + 30;
        displayForTeamB(teamBScore);
    }
    /**
     * This will give Team B 50 points for a hard question.
     */

    public void teamB50Pts(View view) {
        teamBScore = teamBScore + 50;
        displayForTeamB(teamBScore);
    }
    /**
     * Team B will be penalized 10 points.
     */

    public void teamBMiss(View view) {
        teamBScore = teamBScore - 10;
        displayForTeamB(teamBScore);
    }

    /**
     * Displays the given score for Team B.
     */

    private void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This will reset the scores for both teams.
     */

    public void resetTeamScores (View view) {
        teamAScore = 0;
        displayForTeamA(teamAScore);
        teamBScore = 0;
        displayForTeamB(teamBScore);
    }

    public void submitScores (View v) {

        String nameA = nameOfTeamA.getText().toString();
        String nameB = nameOfTeamB.getText().toString();

        if (nameOfTeamA.getText().toString().equals("")) {
            nameA = "Team A";
        }

        if (nameOfTeamB.getText().toString().equals("")) {
            nameB = "Team B";
        }

        if (teamAScore > teamBScore) {
            String scoreMessage = getString(R.string.team_a_wins, nameA, teamAScore);
            Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();
        } else if (teamAScore < teamBScore) {
            String scoreMessage = getString(R.string.team_b_wins, nameB, teamBScore);
            Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();

        } else if (teamAScore == teamBScore) {

            String scoreMessage = getString(R.string.both_teams_tie, teamAScore);
            Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();

        }
    }






}
