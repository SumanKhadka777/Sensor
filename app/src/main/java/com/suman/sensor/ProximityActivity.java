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

public class ProximityActivity extends AppCompatActivity {

    EditText etfirst,etsecond;
    TextView tvadd;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);
        etfirst=findViewById(R.id.etfirst);
        etsecond=findViewById(R.id.etsecond);
        tvadd=findViewById(R.id.tvadd);
       sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor =sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                int one= Integer.parseInt(etfirst.getText().toString());
                int two= Integer.parseInt(etsecond.getText().toString());
                int add= one + two;
                int sub = one- two;
                if (event.values[1] <= 4){
                    tvadd.setText(""+add);

                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };


        if (sensor !=null){
            sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);


        }else {

            Toast.makeText(this, "no sensor found", Toast.LENGTH_SHORT).show();

        }


    }

}
