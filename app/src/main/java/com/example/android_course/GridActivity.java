package com.example.android_course;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
    }

    /*
    II. GridLayout

    New Layout Manager after Android 4.0
    The entire container can be divided into rows*columns grids, each of which can place a component
    You can set how many columns or rows a component spans
    When the cell size is larger than the component size, you can set the location of the component in the cell by setting the layout_grativity attribute value.
    By setting the layout_columnWeight/layout_rowWeight attribute value, you can set the size ratio of each component.
     */
}