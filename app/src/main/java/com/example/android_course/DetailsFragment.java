package com.example.android_course;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailsFragment extends Fragment {

    private  int id;

    public DetailsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        TextView nameView = view.findViewById(R.id.name);
        TextView descriptionView = view.findViewById(R.id.description);
        if(id == 1){
            nameView.setText("E1");
            descriptionView.setText("ED1");
        }else{
            nameView.setText("NotFound!");
            descriptionView.setText("NotFound!");
        }
    }

    public void setId(int id) {
        this.id = id;
    }
}