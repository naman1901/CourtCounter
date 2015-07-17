package com.example.android.courtcounter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int scoreA, scoreB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        scoreA=scoreB=0;
        getTeamName(context);
        setContentView(R.layout.activity_main);
    }

    /**
     * Gets the names for the teams.
     */
    private void getTeamName(Context context){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promptView = layoutInflater.inflate(R.layout.team_name_prompt, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setView(promptView);
        final EditText inputA = (EditText) promptView.findViewById(R.id.team_a_name);
        final EditText inputB = (EditText) promptView.findViewById(R.id.team_b_name);

        alertDialogBuilder.setCancelable(false).setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        displayNameTeamA(inputA.getText().toString());
                        displayNameTeamB(inputB.getText().toString());
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alertD = alertDialogBuilder.create();
        alertD.show();
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    /**
     * Displays Team A's name.
     */

    private void displayNameTeamA(String name) {
        TextView teamName = (TextView) findViewById(R.id.team_a_name);
        if(name.length()!=0)
            teamName.setText(name);
    }

    /**
     * Displays Team B's name.
     */

    private void displayNameTeamB(String name) {
        TextView teamName = (TextView) findViewById(R.id.team_b_name);
        if(name.length()!=0)
            teamName.setText(name);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Updates the score for Team A.
     */
    public void Aplus3(View view){
        scoreA+=3;
        displayForTeamA(scoreA);
    }

    public void Aplus2(View view){
        scoreA+=2;
        displayForTeamA(scoreA);
    }

    public void Aplus1(View view){
        scoreA+=1;
        displayForTeamA(scoreA);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Updates the score for Team B.
     */
    public void Bplus3(View view){
        scoreB+=3;
        displayForTeamB(scoreB);
    }

    public void Bplus2(View view){
        scoreB+=2;
        displayForTeamB(scoreB);
    }

    public void Bplus1(View view){
        scoreB+=1;
        displayForTeamB(scoreB);
    }

    /**
     * Resets the score.
     */
    public void resetScore(View view){
        scoreA=scoreB=0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }
}
