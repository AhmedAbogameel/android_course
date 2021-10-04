package com.example.android_course;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int seconds;
    boolean isRunning;
    boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            this.seconds = savedInstanceState.getInt("seconds");
            this.isRunning = savedInstanceState.getBoolean("isRunning");
        }
        runTimer();
    }

    private void runTimer() {
        final TextView textView = findViewById(R.id.textView);

        final  Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                String hour = String.valueOf(seconds / 3600);
                String minute = String.valueOf((seconds % 3600) / 60);
                String second = String.valueOf(seconds % 60);
                String displayedTimer = (hour.length() == 1 ? "0"+hour : hour) + ":" + (minute.length() == 1 ? "0"+minute :minute) + ":" + (second.length() == 1 ? "0"+second : second);
                textView.setText(displayedTimer);
                if(isRunning){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void onStartClicked(View view) {
        isRunning = true;
    }

    public void onStopClicked(View view) {
        isRunning = false;
    }

    public void onResetClicked(View view) {
        seconds = 0;
        isRunning = false;
    }

    // Called after OnCreate
    @Override
    protected void onStart() {
        super.onStart();
        isRunning = wasRunning;
    }

    // Partial Hide
    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;
    }

    // Total Hide
    @Override
    protected void onStop() {
        super.onStop();
        wasRunning = isRunning;
        isRunning = false;
    }

    // User can interact with UI
    @Override
    protected void onResume() {
        super.onResume();
    }

    // Called before on Destroy
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", this.seconds);
        outState.putBoolean("isRunning", this.isRunning);
    }

    // Called when android kill the activity
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}