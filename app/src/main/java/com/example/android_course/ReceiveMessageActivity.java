package com.example.android_course;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiveMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message); // inflate
        setScreenData();
    }

    private void setScreenData(){
        TextView textView = findViewById(R.id.msgText);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        textView.setText(message);
    }

}