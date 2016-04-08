package edu.washington.echee.accelerometerexample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Rooms extends AppCompatActivity {

    //declaring the global variable
    gcshGlobal globals = gcshGlobal.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        Vibrator vibrator = (Vibrator) getSystemService(this.VIBRATOR_SERVICE);
        vibrator.vibrate(100);

    }
    /** Called when the user clicks Room 01 button */
    public void equipmentLauncher01(View view){
        globals.setRoom("R1");
        Intent equipmentIntent = new Intent(this, Equipment.class);
        startActivity(equipmentIntent);
        // pass a variable here
    }

/** Called when the user clicks Room 02 button */
    public void equipmentLauncher02(View view){
        globals.setRoom("R2");
        Intent equipmentIntent = new Intent(this, Equipment.class);
        startActivity(equipmentIntent);
        // pass a variable here
    }
/** Called when the user clicks Room 03 button */
    public void equipmentLauncher03(View view){
        globals.setRoom("R3");
        Intent equipmentIntent = new Intent(this, Equipment.class);
        startActivity(equipmentIntent);
        // pass a variable here
    }

    public void exitApp(View view) {
        System.exit(0);
    }
}

