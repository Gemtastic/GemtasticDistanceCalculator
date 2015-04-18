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
 * Created by Gemtastic on 2015-04-18.
 */
public class ResponseActivity extends Activity implements SensorEventListener{

    Sensor accelerometer;
    SensorManager sm;

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

        TextView mainActivityMessage = (TextView) findViewById(R.id.result);

        TextView displayMessage = (TextView) findViewById(R.id.message);

        mainActivityMessage.append(" " + appendText);

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

    @Override
    public void onSensorChanged(SensorEvent event) {

        float x = event.values[0];

        if(x < -4 || x > 4){
            finish();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Irrelevant
    }
}
