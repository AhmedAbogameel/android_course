package com.example.android_course;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DrinkDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_details);

        Intent intent = getIntent();
        int drinkId = intent.getIntExtra("drinkId", 0);

        // Arrays Contain data { We will replace with table}
        String[] drinks = {"1", "2", "3"};
        String[] drinksDetails = {"d1", "d2", "d3"};
        int[] drinksImages = {R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};

        TextView name = findViewById(R.id.drinkName);
        TextView details = findViewById(R.id.drinkDetails);
        ImageView image = findViewById(R.id.drinkImage);

        name.setText(drinks[drinkId]);
        details.setText(drinksDetails[drinkId]);
        image.setImageResource(drinksImages[drinkId]);
    }
}