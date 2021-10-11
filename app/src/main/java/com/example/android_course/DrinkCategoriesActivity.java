package com.example.android_course;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DrinkCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_categories);
        String[] drinks = {"1", "2", "3"};

        // Adapter
        ListView listView = findViewById(R.id.drinks_list);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, drinks);
        listView.setAdapter(arrayAdapter);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long index) {
                Intent intent = new Intent(DrinkCategoriesActivity.this, DrinkDetailsActivity.class);
                intent.putExtra("drinkId", (int) index);
                startActivity(intent);
            }
        };

        listView.setOnItemClickListener(onItemClickListener);
    }
}