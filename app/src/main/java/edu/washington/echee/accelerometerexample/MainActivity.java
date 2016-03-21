package edu.washington.echee.accelerometerexample;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
//import android.view.View;
//import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.*;
import java.net.*;
//import java.lang.Object;
//import java.util.List;


public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private static final String TAG = MainActivity.class.getSimpleName();

    public Socket socket;
    //DataOutputStream outToServer = null;
    //Button buttonConnect;
    Thread tcpThread;
    DataOutputStream dataOutputStream = null;
    DataInputStream dataInputStream = null;

    private GoogleApiClient client;

    public MainActivity() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tcpThread = new Thread(new ClientThread());
        tcpThread.start();

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER) == null) {
            // There is no accelerometer
            Log.i(TAG, "Accelerometer has not detected :(");

        }
        else {
            // Found accelerometer
            Log.i(TAG, "Accelerometer is detected!");
            mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float xvalue = sensorEvent.values[0];
        float yvalue = sensorEvent.values[1];
        float zvalue = sensorEvent.values[2];

        String X = Float.toString(xvalue);
        String Y = Float.toString(yvalue);
        String Z = Float.toString(zvalue);

        TextView tvXAxis = (TextView) findViewById(R.id.tvXAxis);
        TextView tvYAxis = (TextView) findViewById(R.id.tvYAxis);
        TextView tvZAxis = (TextView) findViewById(R.id.tvZAxis);

        tvXAxis.setText(getString(R.string.x_axis, xvalue));
        tvYAxis.setText(getString(R.string.y_axis, yvalue));
        tvZAxis.setText(getString(R.string.z_axis, zvalue));

        try {
            if ((zvalue <= 7.1 && zvalue >= 6.5) && (yvalue <= 7.1 && yvalue >= 6.5))
                dataOutputStream.writeUTF("A1" + "\n");
                //dataOutputStream.writeUTF("A:" + X + " " + Y + " " + Z + "#" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if ((zvalue <= 7.1 && zvalue >= 6.5) && (yvalue <= -6.5 && yvalue >= -7.1))
                dataOutputStream.writeUTF("A2" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

/*
        try {
            if (zvalue <= 8.1 && yvalue <= 8.1) {
                //dataOutputStream.writeInt("A " + X + " " + Y + " " + Z);
                dataOutputStream.writeUTF("A:" + X + " " + Y + " " + Z +"#");
                //dataOutputStream.writeUTF("X value is " + X);
                //dataOutputStream.writeUTF("Y value is " + Y);
                //dataOutputStream.writeUTF("Z value is " + Z);
               // client.disconnect();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }


    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
        // For diff update intervals, use
        //      SENSOR_DELAY_NORMAL     200,000ms
        //      SENSOR_DELAY_UI          60,000ms
        //      SENSOR_DELAY_GAME        20,000ms
        //      SENSOR_DELAY_FASTEST          0ms
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


    public void connect() {

        try {
            //socket = new Socket("194.47.46.100", 4444);   // my IP
            socket = new Socket("194.47.40.69", 4444);     // pearsons IP

            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://edu.washington.echee.accelerometerexample/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://edu.washington.echee.accelerometerexample/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


    class ClientThread implements Runnable {

        @Override
        public void run() {
            connect();
        }
    }
}