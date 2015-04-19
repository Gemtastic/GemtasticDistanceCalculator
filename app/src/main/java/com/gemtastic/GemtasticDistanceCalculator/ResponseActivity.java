package com.gemtastic.GemtasticDistanceCalculator;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * This is the result activity; it displays the result from
 * the calculations and handles the sensor.
 *
 * Created by Gemtastic on 2015-04-18.
 */
public class ResponseActivity extends Activity implements SensorEventListener{

    Sensor accelerometer;
    SensorManager sm;

    /**
     * This method sets up the sensor and its manager, edits the TextViews
     * to display the appropriate text depending on what the calculations
     * were about.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        setContentView(R.layout.result_activity);

        Intent activityThatCalled = getIntent();

        String result = activityThatCalled.getExtras().getString("resultActivity");
        String message = activityThatCalled.getExtras().getString("resultType");

        String appendText = result + " m.";

        // Displays the result and the appropriate message text.
        TextView mainActivityMessage = (TextView) findViewById(R.id.result);
        TextView displayMessage = (TextView) findViewById(R.id.message);
        mainActivityMessage.append(" " + appendText);


        // Compares the value in the resultType key to determine what message to display.
        if(message.equals("dry")){
            String text = getResources().getString(R.string.dry);
            displayMessage.setText(text);
        }else if(message.equals("distance")){
            String text = getResources().getString(R.string.distance);
            displayMessage.setText(text);
        }else{
            String text = getResources().getString(R.string.slippery);
            displayMessage.setText(text);
        }
    }

    /**
     * Sensor method listening for a shake. The shake determine if the
     * activity should be finished or not.<p>
     *
     * The shake is defined to the left and the right of the X axis.
     *
     * @param event
     */
    @Override
    public void onSensorChanged(SensorEvent event) {

        float x = event.values[0];

        if(x < -4 || x > 4){
            finish();
        }
    }

    /**
     * This method is not used in this application.
     * @param sensor
     * @param accuracy
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Irrelevant
    }
}
