package edu.washington.echee.accelerometerexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Equipment extends AppCompatActivity {

    //declaring the global variable
    gcshGlobal globals = gcshGlobal.getInstance();

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

    /** Called when the user clicks FL button */
    public void switchLauncherFL(View view){
        globals.setEquipment("FL");
        Intent switchIntent = new Intent(this, MainActivity.class);
        startActivity(switchIntent);
        // pass a variable here
    }
/** Called when the user clicks CR button */
    public void switchLauncherCR(View view){
        globals.setEquipment("CR");
        Intent switchIntent = new Intent(this, MainActivity.class);
        startActivity(switchIntent);
        // pass a variable here
    }
/** Called when the user clicks FN button */
    public void switchLauncherFN(View view){
        globals.setEquipment("FN");
        Intent switchIntent = new Intent(this, MainActivity.class);
        startActivity(switchIntent);
        // pass a variable here
    }
    /** Called when the user clicks CL button */
    public void switchLauncherCL(View view){
        globals.setEquipment("CL");
        Intent switchIntent = new Intent(this, MainActivity.class);
        startActivity(switchIntent);
        // pass a variable here
    }


    public void exitEquipment(View view) {
        finish();
    }

//    /* called when the user clicks ceiling lamp*/
//    public void ceilingLampLauncher(View view) {
//        //globals.setEquipment("FL");    // this will be done in the ceiling lamp activity
//        Intent switchIntent2 = new Intent(this, CeilingLamp.class);
//        startActivity(switchIntent2);
//        // pass a variable here
//    }
}
