package edu.washington.echee.accelerometerexample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Intro extends AppCompatActivity {

    //declaring the global variable
    gcshGlobal globals = gcshGlobal.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.abc_ic_menu_cut_mtrl_alpha);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                System.exit(0);
            }
        });

        Vibrator vibrator = (Vibrator) getSystemService(this.VIBRATOR_SERVICE);
        vibrator.vibrate(100);

        //to initialize it so that it won't crash
        //globals.setIP("194.47.40.107");
    }

    //public EditText ipInput = (EditText) findViewById(R.id.ipInputId);
    //public String ipStr = ipInput.getText().toString();

    public void roomLauncher(View view) {
        final EditText ipInput = (EditText) findViewById(R.id.ipInputId);
        //globals.setIP("194.47.40.107");
        //globals.setIP(ipStr);
        globals.setIP(ipInput.getText().toString());
        Intent roomsIntent = new Intent(this, Rooms.class);
        startActivity(roomsIntent);
    }
}
