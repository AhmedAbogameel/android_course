package com.example.android_course;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        EditText msgText = findViewById(R.id.msgText);
        // Explicit Intent
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra("message","Welcome " + msgText.getText().toString());
        startActivity(intent);
    }

    public void onEmailCLicked(View view) {
        EditText msgText = findViewById(R.id.msgText);
        // Implicit Intent
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(Intent.EXTRA_TEXT, msgText.getText().toString());
        startActivity(intent);
    }
}