package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "State: Created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "State: Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "State: Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "State: Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "State: Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "State: Destroyed");
    }
}