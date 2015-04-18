package com.gemtastic.GemtasticDistanceCalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private final static Calculations calculations = new Calculations();

    private Button stopDist;
    private Button distTravel;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stopDist = (Button) findViewById(R.id.stopDistWet);
        distTravel = (Button) findViewById(R.id.disTravel);
        exit = (Button) findViewById(R.id.exit);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }


    public void onStopDistDryClick(View view){

        EditText numberInput = (EditText) findViewById(R.id.speed);
        String input = numberInput.getText().toString();

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

    public void onDistTravelClick(View view){

        EditText numberInput = (EditText) findViewById(R.id.speed);

        String input = numberInput.getText().toString();

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

    public void onExitClick(View view){
        finish();
    }
}
