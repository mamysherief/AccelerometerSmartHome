package edu.washington.echee.accelerometerexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Equipment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
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
    }

    /** Called when the user clicks Room 01 button */
    public void switchLauncher(View view){
        Intent switchIntent = new Intent(this, MainActivity.class);
        startActivity(switchIntent);
        // pass a variable here
    }

    public void exitEquipment(View view) {
        finish();
    }

    /* called when the user clicks ceiling lamp*/
    public void ceilingLampLauncher(View view) {
        Intent switchIntent2 = new Intent(this, CeilingLamp.class);
        startActivity(switchIntent2);
        // pass a variable here
    }
}
