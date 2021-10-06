package com.example.android_course;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Object View
        Button sendButton = findViewById(R.id.send);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Call another Screen
                Intent intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
                startActivity(intent);
            }
        };

        // Register
        sendButton.setOnClickListener(listener);
    }


    public void onSend(View view) {

    }

    public void onCall(View view) {

    }
}