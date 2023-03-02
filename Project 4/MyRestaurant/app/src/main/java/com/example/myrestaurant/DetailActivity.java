package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ArrayList<Food> foodList;
    ArrayList<Cart> cartArrayList;
    int quantity;
    double price;
    int id;
    Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        id = intent.getIntExtra("FoodID", 0);
        String databasesName = intent.getStringExtra("FoodList");
        String ramenList = "Database.ramenList";
        String dumplingsList = "Database.dumplingsList";
        String sushiList = "Database.sushiList";
        String bubbleTeaList = "Database.bubbleTeaList";

        if (databasesName.equals(ramenList)){
             foodList = Database.ramenList;
        }   else if (databasesName.equals(dumplingsList)){
            foodList = Database.dumplingsList;
        }   else if (databasesName.equals(sushiList)){
            foodList = Database.sushiList;
        }   else if (databasesName.equals(bubbleTeaList)){
            foodList = Database.bubbleTeaList;
        }   else {
            foodList = null;
        }

        for (int i=0; i < foodList.size(); i++) {
            if (foodList.get(i).getId() == id) {
                food = foodList.get(i);
                ImageView imageView = findViewById(R.id.itemImage);
                imageView.setImageResource(food.getImage());
                TextView textViewName =  findViewById(R.id.itemName);
                textViewName.setText(food.getName());
                TextView textViewDescription = findViewById(R.id.itemDescription);
                textViewDescription.setText(food.getDescription());
                TextView textViewPrice = findViewById(R.id.itemPrice);
                DecimalFormat df = new DecimalFormat("0.00");
                textViewPrice.setText("" + food.getPrice());
                price = food.getPrice();
            }
        }
    }

    public void submitButton (View view) {
        EditText editText = (EditText) findViewById(R.id.quantity);
        String value = editText.getText().toString();
        String empty = "";
        if (value == null || value.equals(empty)) {
            Context context = getApplicationContext();
            CharSequence text = "No Amount Selected";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            quantity = Integer.parseInt(value);
            loadData();
            saveData();
            finish();
        }
    }

    private void saveData () {
        boolean check = false;
        for (int i = 0; i < cartArrayList.size(); i++) {
            if (cartArrayList.get(i).getFoodName().equals(food.getName())) {
                int previousQuantity = cartArrayList.get(i).getQuantity();
                cartArrayList.get(i).setQuantity(quantity+previousQuantity);
                check = true;
            }
        } if (check == false) {
            cartArrayList.add(new Cart(food, quantity));
        }

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(cartArrayList);
        editor.putString("cart", json);
        editor.apply();
    }

    private void loadData () {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("cart", null);
        Type type = new TypeToken<ArrayList<Cart>>() {}.getType();
        cartArrayList = gson.fromJson(json,type);
        if (cartArrayList == null) {
            cartArrayList = new ArrayList<Cart>();
            Log.e("doesItWork", "Array was empty");
        }
    }
}