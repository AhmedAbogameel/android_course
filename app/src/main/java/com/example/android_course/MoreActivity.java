package com.example.android_course;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
    }

    public void onCheckClick(View view) {
        TextView textView = findViewById(R.id.textView);
        CheckBox checkBox = (CheckBox) view;
        if(checkBox.isChecked()){
            textView.setText("Meat");
        }else{
            textView.setText("No Meat");
        }
    }

    public void onRadioClick(View view) {
        TextView textView = findViewById(R.id.textView);
        if(view.getId() == R.id.radioMale){
            textView.setText("Male");
        }else{
            textView.setText("Female");
        }
    }

    public void onSwitchClick(View view) {
        TextView textView = findViewById(R.id.textView);
        Switch checkBox = (Switch) view;
        if(checkBox.isChecked()){
            textView.setText("On");
        }else{
            textView.setText("Off");
        }
    }

    public void onToastClick(View view) {
        Toast toast = Toast.makeText(this, "We are perfect!", Toast.LENGTH_LONG);
        toast.show();
    }
}