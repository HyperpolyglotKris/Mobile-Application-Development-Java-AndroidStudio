package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int filter;
    ViewPager2 viewPager;
    ListView listView;
    ArrayList<Restaurant> restaurantArrayList;
    ArrayList<Restaurant> featuredArrayList;
    ArrayList<Restaurant> featuredRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        filter = intent.getIntExtra("Filter", 0);

        initiate();
    }

    public void initiate() {
        viewPager = findViewById(R.id.pager);
        listView = findViewById(R.id.list);

        restaurantArrayList = DataSource.getRestaurantList();

        // Use sorting algorithms for the Array
        restaurantArrayList = sortArrayList(filter);
        featuredArrayList = restaurantArrayList;

        // Find featured restaurants among all restaurants stop at 3
        if (featuredRestaurants == null || featuredRestaurants.size() ==0) {
            featuredRestaurants = new ArrayList<>();
            for (int i = 0; i < featuredArrayList.size(); i++) {
                if (featuredArrayList.get(i).isFeatured()) {
                    featuredRestaurants.add(featuredArrayList.get(i));
                    Log.e("Testing", "Index = " + i);
                }
                if (featuredRestaurants.size() == 3) {
                    break;
                }
            }
        }

        // Adapter for featured restaurants
        AdapterFeatured adapterFeatured = new AdapterFeatured(MainActivity.this, featuredRestaurants);
        viewPager.setAdapter(adapterFeatured);

        // Adapter for all the restaurants
        AdapterList adapterList = new AdapterList(MainActivity.this, R.layout.adapter_list, restaurantArrayList);
        listView.setAdapter(adapterList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filters, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        switch (item.getItemId()) {
            case R.id.price_low_high:
                filter = 1;
                intent.putExtra("Filter", filter);
                startActivity(intent);
                finish();
                return true;
            case R.id.price_high_low:
                filter = 2;
                intent.putExtra("Filter", filter);
                startActivity(intent);
                finish();
                return true;
            case R.id.rating:
                filter = 3;
                intent.putExtra("Filter", filter);
                startActivity(intent);
                finish();
                return true;
            case R.id.vegan:
                filter = 4;
                intent.putExtra("Filter", filter);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Log.e("Testing", "onBackPressed Called");
        Intent setIntent = new Intent(MainActivity.this, MainActivity.class);
        if (filter>0) {
            setIntent.putExtra("Filter", 0);
            startActivity(setIntent);
        } else {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }
    }

    public ArrayList<Restaurant> sortArrayList(int filter){
        Restaurant temp;
        ArrayList<Restaurant> sortedArrayList = DataSource.getRestaurantList();
        switch (filter) {
            case 1:
                Log.e("Testing", "Sorting Case 1");
                for (int i = 0; i < sortedArrayList.size(); i++) {
                    for (int j = i + 1; j < sortedArrayList.size(); j++) {
                        if (sortedArrayList.get(i).getDeliveryFee() > sortedArrayList.get(j).getDeliveryFee()) {
                            temp = sortedArrayList.get(i);
                            sortedArrayList.set(i, sortedArrayList.get(j));
                            sortedArrayList.set(j, temp);
                        }
                    }
                }
                break;
            case 2:
                Log.e("Testing", "Sorting Case 2");
                for (int i = 0; i < sortedArrayList.size(); i++) {
                for (int j = i + 1; j < sortedArrayList.size(); j++) {
                    if (sortedArrayList.get(i).getDeliveryFee() < sortedArrayList.get(j).getDeliveryFee()) {
                        temp = sortedArrayList.get(i);
                        sortedArrayList.set(i, sortedArrayList.get(j));
                        sortedArrayList.set(j, temp);
                    }
                }
            }
                break;
            case 3:
                Log.e("Testing", "Sorting Case 3");
                for (int i = 0; i < sortedArrayList.size(); i++) {
                    for (int j = i + 1; j < sortedArrayList.size(); j++) {
                        if (sortedArrayList.get(i).getRating() < sortedArrayList.get(j).getRating()) {
                            temp = sortedArrayList.get(i);
                            sortedArrayList.set(i, sortedArrayList.get(j));
                            sortedArrayList.set(j, temp);
                        }
                    }
                }
                break;
            case 4:
                Log.e("Testing", "Sorting Case 4");
                for (int i = 0; i < sortedArrayList.size(); i++) {
                    for (int j = i + 1; j < sortedArrayList.size(); j++) {
                        if (!sortedArrayList.get(i).isVegetarian() && sortedArrayList.get(j).isVegetarian()) {
                            temp = sortedArrayList.get(i);
                            sortedArrayList.set(i, sortedArrayList.get(j));
                            sortedArrayList.set(j, temp);
                        }
                    }
                }
                break;
            default:
                Log.e("Testing", "Sorting Default");
                break;
        }
        return sortedArrayList;
    }
}