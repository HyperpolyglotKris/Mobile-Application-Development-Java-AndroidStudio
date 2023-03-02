package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    int settingsSeasonID, savedSeasonID, seasonID;
    Intent settingSeasonIntent;
    ImageView background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("appSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("seasonInfo", seasonID);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        initiate();
    }

    public void initiate() {
        background = findViewById(R.id.seasonImageView);

        // Get savedSeasonID from sharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("appSettings", MODE_PRIVATE);
        savedSeasonID = sharedPreferences.getInt("seasonInfo",  0);

        // Get intent from settings
        settingSeasonIntent = getIntent();
        settingsSeasonID = getIntent().getIntExtra("season", 4);

        // Assign either savedSeasonID or settingsSeasonID to seasonID
        if (settingsSeasonID == 4) {
            seasonID = savedSeasonID;
        } else {
            seasonID = settingsSeasonID;
        }

        // Use seasonID to change background image
        if (seasonID == 0) {
            background.setImageResource(R.drawable.spring);
        } else if (seasonID == 1) {
            background.setImageResource(R.drawable.summer);
        } else if (seasonID == 2) {
            background.setImageResource(R.drawable.autumn);
        } else if (seasonID == 3) {
            background.setImageResource(R.drawable.winter);
        }

        // Initializing settings button, creating initializer, open new activity
        imageButton = (ImageButton) findViewById(R.id.settings);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                Intent intentSettings = new Intent(MainActivity.this, MainActivity2.class);
                intentSettings.putExtra("season", seasonID);
                startActivity(intentSettings);
            }
        });
    }


}