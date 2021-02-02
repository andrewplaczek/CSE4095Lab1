package com.example.cse4095lab1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String ON_CREATE = "In OnCreate: ";
    final String ON_START = "In OnStart: ";
    final String ON_RESUME = "In OnResumed: ";
    final String ON_PAUSED = "In OnPause: ";
    final String ON_STOP = "In OnStop: ";
    final String ON_DESTROY = "In OnDestroy: ";
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i(ON_CREATE, "Started onCreate: non-existant to stopped");

        Button btn = findViewById(R.id.button);
        TextView tview = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                i++;
                String str;
                if (i == 1) {
                    str = "This Button Has Been Clicked " + i + " Time.";
                }
                else{
                    str = "This Button Has Been Clicked " + i + " Times.";
                }
                tview.setText(str);
            }
        });

    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i(ON_START,"Stopped to paused");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(ON_RESUME,"Paused to resumed");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(ON_PAUSED, "Resumed to paused");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i(ON_STOP,"Paused to stopped");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(ON_DESTROY,"Stopped to Non existant");
    }
}