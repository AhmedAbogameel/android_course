package com.example.android_course;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void onClick(View view) {
        TextView nameTexView = findViewById(R.id.selected_color);
        Spinner spinner = findViewById(R.id.spinner);
        String text = spinner.getSelectedItem().toString();
        nameTexView.setText(text);
    }

}