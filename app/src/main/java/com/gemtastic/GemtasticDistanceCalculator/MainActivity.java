package com.gemtastic.GemtasticDistanceCalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This is the main activity. Most of the application happens here.
 *
 *
 */
public class MainActivity extends ActionBarActivity {

    private final static Calculations calculations = new Calculations();

    private Button stopDistWet;
    private Button stopDistDry;
    private Button distTravel;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stopDistWet = (Button) findViewById(R.id.stopDistWet);
        stopDistDry = (Button) findViewById(R.id.stopDistDry);
        distTravel = (Button) findViewById(R.id.disTravel);
        exit = (Button) findViewById(R.id.exit);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }


    /**
     * This button handler calls for the logic of stopping on a dry road and
     * sets the ResponseActivity with the appropriate keys for the dry road option.
     *
     * @param view
     */
    public void onStopDistDryClick(View view){

        EditText numberInput = (EditText) findViewById(R.id.speed);
        String input = numberInput.getText().toString();

        // Makes sure the user doesn't try to send empty EditText into the calculation
        if(!input.isEmpty()){
            int speed = Integer.parseInt(input);

            int distance = calculations.dry(speed);

            Bundle bundle = new Bundle();
            bundle.putString("resultActivity", String.valueOf(distance));
            bundle.putString("resultType", "dry");

            Intent getScreenIntent = new Intent(this, ResponseActivity.class);

            getScreenIntent.putExtras(bundle);
            startActivity(getScreenIntent);
        }

    }

    /**
     * This button handler calls for the logic of stopping on a slippery or wet road as
     * well as sets the ResponseActivity with the appropriate keys for the wet road option.
     *
     * @param view
     */
    public void onStopDistWetClick(View view){

        EditText numberInput = (EditText) findViewById(R.id.speed);

        String input = numberInput.getText().toString();

        if(!input.isEmpty()){
            int speed = Integer.parseInt(input);

            int distance = calculations.slippery(speed);

            Bundle bundle = new Bundle();
            bundle.putString("resultActivity", String.valueOf(distance));
            bundle.putString("resultType", "wet");

            Intent getScreenIntent = new Intent(this, ResponseActivity.class);

            getScreenIntent.putExtras(bundle);
            startActivity(getScreenIntent);
        }

    }

    /**
     * This button handler handles the distance you travel for 3 seconds. It calls for
     * the logic of calculating it and sets ResponseActivity up with the correct keys
     * and text.
     *
     * @param view
     */
    public void onDistTravelClick(View view){

        EditText numberInput = (EditText) findViewById(R.id.speed);

        String input = numberInput.getText().toString();

        // Makes sure the user doesn't try to send empty EditText into the calculation
        if(!input.isEmpty()){
            int speed = Integer.parseInt(input);

            int distance = calculations.howFarYouGo(speed);

            Bundle bundle = new Bundle();
            bundle.putString("resultActivity", String.valueOf(distance));
            bundle.putString("resultType", "distance");

            Intent getScreenIntent = new Intent(this, ResponseActivity.class);

            getScreenIntent.putExtras(bundle);
            startActivity(getScreenIntent);
        }

    }

    /**
     * This button handler exits the application.
     *
     * @param view
     */
    public void onExitClick(View view){
        finish();
    }
}
