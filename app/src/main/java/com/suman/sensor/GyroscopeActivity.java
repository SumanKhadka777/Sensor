package com.suman.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GyroscopeActivity extends AppCompatActivity {

    EditText etone, ettwo;
    TextView tvresult;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        setTitle("Gyroscope sensor");

        etone= findViewById(R.id.etone);
        ettwo= findViewById(R.id.ettwo);
        tvresult= findViewById(R.id.tvresult);
        sensorGyro();
    }

    private void sensorGyro(){

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        SensorEventListener gyrolistener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

              int one= Integer.parseInt(etone.getText().toString());
              int two= Integer.parseInt(ettwo.getText().toString());
              int add= one + two;
              int sub = one- two;
                if (event.values[1] < 0){
                    tvresult.setText(""+add);

                }
                else if (event.values[1]>0){
                    tvresult.setText(""+sub);

                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        if (sensor !=null){
            sensorManager.registerListener(gyrolistener, sensor, SensorManager.SENSOR_DELAY_NORMAL);


        }else {

            Toast.makeText(this, "no sensor found", Toast.LENGTH_SHORT).show();

        }






    }
}
