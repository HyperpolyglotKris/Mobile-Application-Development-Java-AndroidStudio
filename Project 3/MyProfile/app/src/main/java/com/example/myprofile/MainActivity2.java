package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.lang.reflect.Parameter;

public class MainActivity2 extends AppCompatActivity {
    Spinner themesSpinner;
    Button confirm;
    int themeID, seasonID;
    Intent settingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initialise();


        // Getting intent and setting the spinner to right position
        settingIntent = getIntent();
        if (settingIntent != null) {
            seasonID = settingIntent.getIntExtra("season", 0);
            if (seasonID == 0) {
                themesSpinner.setSelection(0);
            } else if (seasonID == 1) {
                themesSpinner.setSelection(1);
            } else if (seasonID == 2) {
                themesSpinner.setSelection(2);
            } else if (seasonID == 3) {
                themesSpinner.setSelection(3);
            }
        }



    }
    public void initialise() {
        themesSpinner = findViewById(R.id.spinner);
        confirm = findViewById(R.id.confirmButton);

        // Creating the spinner listener and other variables
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.selectedTheme, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themesSpinner.setAdapter(dataAdapter);
        themesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                themeID = themesSpinner.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        // Creating the button listener and sending intent
        confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int themeID = themesSpinner.getSelectedItemPosition();

                Intent season = new Intent(MainActivity2.this, MainActivity.class);
                season.putExtra("season", themeID);

                startActivity(season);
                finish();
            }
        });
    }

}