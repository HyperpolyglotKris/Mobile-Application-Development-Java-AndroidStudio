package com.example.restaurantapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    String databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FoodCategoryFragment foodCategoryFragment = new FoodCategoryFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.top_fragment, foodCategoryFragment).commit();

        Bundle bundleList = new Bundle();
        bundleList.putInt("CategoryID", 1);
        FoodListFragment foodListFragment = new FoodListFragment();
        foodListFragment.setArguments(bundleList);
        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_fragment, foodListFragment).commit();

        // Navigation Bar
        ImageView imageView = findViewById(R.id.menu_icon);
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id) {
                    case R.id.nav_search:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(MainActivity.this, "Opening Food Menu", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_favorites:
                        Intent intent = new Intent(MainActivity.this, CartActivity.class);
                        startActivity(intent);

                        Toast.makeText(MainActivity.this, "Opening Cart", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }
}
