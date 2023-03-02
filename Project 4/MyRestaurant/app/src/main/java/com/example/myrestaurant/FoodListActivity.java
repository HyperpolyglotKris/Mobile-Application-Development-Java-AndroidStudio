package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity implements Serializable {
    ArrayList<Food> database;
    String databaseName;
    ArrayList<Cart> cartArrayList;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        Intent intent = getIntent();
        int id = intent.getIntExtra("CategoryID", 0);

        switch (id) {
            case 1:
                database = Database.ramenList;
                databaseName = "Database.ramenList";
                break;
            case 2:
                database = Database.dumplingsList;
                databaseName = "Database.dumplingsList";
                break;
            case 3:
                database = Database.sushiList;
                databaseName = "Database.sushiList";
                break;
            case 4:
                database = Database.bubbleTeaList;
                databaseName = "Database.bubbleTeaList";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }

        ListView listView = (ListView) findViewById(R.id.listView);
        FoodListAdapter adapter = new FoodListAdapter(FoodListActivity.this, R.layout.adapter_view_layout, database);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    public void launchDetailActivity (View view) {
        ListView listView = findViewById(R.id.listView);
        int id = listView.getPositionForView(view) + 1;

        Intent intent = new Intent(FoodListActivity.this, DetailActivity.class);
        intent.putExtra("FoodID", id);
        intent.putExtra("FoodList", databaseName);
        startActivity(intent);
    }

    public void launchCartActivity (View view) {
        Intent intent = new Intent(FoodListActivity.this, CartActivity.class);
        startActivity(intent);
    }

    private void loadData () {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("cart", null);
        Type type = new TypeToken<ArrayList<Cart>>() {}.getType();
        cartArrayList = gson.fromJson(json,type);
        TextView textViewTotal = findViewById(R.id.totalPrice);
        DecimalFormat df = new DecimalFormat("0.00");
        if (cartArrayList == null || cartArrayList.size()== 0) {
            cartArrayList = new ArrayList<Cart>();
            textViewTotal.setText("Total Price: 0.00");
        } else {
            textViewTotal.setText("Total Price: " + df.format(cartArrayList.get(0).getTotalPrice()));
        }
    }
}
