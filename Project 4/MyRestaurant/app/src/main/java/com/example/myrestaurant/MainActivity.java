package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchFoodListActivity(View view) {
        int id = 0;
        switch (view.getId()) {
            case R.id.ramen:
                id = 1;
                break;
            case R.id.dumpings:
                id = 2;
                break;
            case R.id.sushi:
                id = 3;
                break;
            case R.id.bubbleTea:
                id = 4;
                break;
        }

        Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
        intent.putExtra("CategoryID", id);
        startActivity(intent);
    }
}


