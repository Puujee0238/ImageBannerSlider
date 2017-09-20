package com.snaprecycleview;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.github.florent37.materialleanback.MaterialLeanBack;
import com.playoffstudio.imagebannerslider.R;
import com.takusemba.multisnaprecyclerview.MultiSnapRecyclerView;

/**
 * Created by takusemba on 2017/08/03.
 */

public class HorizontalActivity extends AppCompatActivity {

    String[] titles = {
            "Android",
            "Beta",
            "Cupcake",
            "Donut"

    };


    String[] imagess = {
            "https://www.w3schools.com/w3images/fjords.jpg",
            "https://www.w3schools.com/w3images/fjords.jpg",
            "https://www.w3schools.com/w3images/fjords.jpg",
            "https://www.w3schools.com/w3images/fjords.jpg"
    };

    MaterialLeanBack materialLeanBack;
    AnimRecycleViewAdapter animRecycleViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal);


        HorizontalAdapter firstAdapter = new HorizontalAdapter(titles);
        MultiSnapRecyclerView firstRecyclerView = (MultiSnapRecyclerView)findViewById(R.id.first_recycler_view);
        LinearLayoutManager firstManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        firstRecyclerView.setLayoutManager(firstManager);
        firstRecyclerView.setAdapter(firstAdapter);

        HorizontalAdapter secondAdapter = new HorizontalAdapter(titles);
        MultiSnapRecyclerView secondRecyclerView =(MultiSnapRecyclerView) findViewById(R.id.second_recycler_view);
        LinearLayoutManager secondManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        secondRecyclerView.setLayoutManager(secondManager);
        secondRecyclerView.setAdapter(secondAdapter);


        AnimRecycleViewAdapter adapter = new AnimRecycleViewAdapter(getApplicationContext() , titles , imagess);
        materialLeanBack = (MaterialLeanBack) findViewById(R.id.materialLeanBack);
        materialLeanBack.setAdapter(adapter);

    }
}