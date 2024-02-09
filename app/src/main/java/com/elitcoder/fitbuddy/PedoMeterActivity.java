package com.elitcoder.fitbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.elitcoder.fitbuddy.databinding.ActivityPedoMeterBinding;

public class PedoMeterActivity extends AppCompatActivity implements SensorEventListener {
    ActivityPedoMeterBinding pedoMeterBinding;
    Sensor sensor;
    SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pedoMeterBinding = ActivityPedoMeterBinding.inflate(getLayoutInflater());
        View view = pedoMeterBinding.getRoot();
        setContentView(view);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if(sensor==null){
            Toast.makeText(this, "Sensor not found!", Toast.LENGTH_SHORT).show();
        }else{
            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float steps = event.values[0];
        pedoMeterBinding.tvSteps.setText((int) steps);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}