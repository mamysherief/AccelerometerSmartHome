package edu.washington.echee.accelerometerexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CeilingLamp extends AppCompatActivity {

    //declaring the global variable
    gcshGlobal globals = gcshGlobal.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceiling_lamp);
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

    public void switchLauncherCL01(View view) {
        globals.setEquipment("CL");
        Intent switchIntent = new Intent(this, MainActivity.class);
        startActivity(switchIntent);
        // pass a variable here
    }
    public void switchLauncherCL02(View view) {
        globals.setEquipment("CL");
        Intent switchIntent = new Intent(this, MainActivity.class);
        startActivity(switchIntent);
        // pass a variable here
    }
    public void switchLauncherCL03(View view) {
        globals.setEquipment("CL");
        Intent switchIntent = new Intent(this, MainActivity.class);
        startActivity(switchIntent);
        // pass a variable here
    }
    public void switchLauncherCL04(View view) {
        globals.setEquipment("CL");
        Intent switchIntent = new Intent(this, MainActivity.class);
        startActivity(switchIntent);
        // pass a variable here
    }
    public void switchLauncherCLALL(View view) {
        globals.setEquipment("CL");
        Intent switchIntent = new Intent(this, MainActivity.class);
        startActivity(switchIntent);
        // pass a variable here
    }

    public void exitCeilingLamp(View view) {
        finish();
    }
}
