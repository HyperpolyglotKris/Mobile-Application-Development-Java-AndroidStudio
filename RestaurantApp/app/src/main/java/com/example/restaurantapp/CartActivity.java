package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ArrayList<Cart> cartArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        loadData();

        if (cartArrayList == null || cartArrayList.size()==0) {
        } else {
            ListView listView = (ListView) findViewById(R.id.cartView);
            CartAdapter adapter = new CartAdapter(CartActivity.this, R.layout.adapter_cart, cartArrayList);
            listView.setAdapter(adapter);
        }
    }

    private void loadData () {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("cart", null);
        Type type = new TypeToken<ArrayList<Cart>>() {}.getType();
        cartArrayList = gson.fromJson(json,type);
        if (cartArrayList == null || cartArrayList.size()== 0) {
            cartArrayList = new ArrayList<Cart>();
        } else {
            TextView textViewTotal = findViewById(R.id.totalPrice);
            DecimalFormat df = new DecimalFormat("0.00");
            textViewTotal.setText("Total Price: " + df.format(cartArrayList.get(0).getTotalPrice()));
        }
    }

    public void onClickClear (View view) {
        Cart.setTotalPrice(0.00);
        cartArrayList.clear();
        saveData();
        finish();
    }

    private void saveData () {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(cartArrayList);
        editor.putString("cart", json);
        editor.apply();
    }
}