package com.example.android_course;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(int id) {
        FrameLayout layout = findViewById(R.id.landFrame);
        if(layout == null){
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }else{
            //BackStack
            System.out.println("back");
            DetailsFragment detailsFragment = new DetailsFragment();
            detailsFragment.setId(id);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.landFragment, detailsFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}