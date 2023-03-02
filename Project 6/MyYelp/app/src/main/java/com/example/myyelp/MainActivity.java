package com.example.myyelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ObjectsAdapter.ItemClickListener {
    Spinner spinner;
    ObjectsArrayList viewModel;
    ArrayList<ObjectsModel> objectsModel;
    SearchView searchView;
    ObjectsAdapter objectsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.sorting_array, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        // Recycler
        RecyclerView recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ObjectsAdapter objectsAdapter = new ObjectsAdapter(this, objectsModel, this);
        recyclerView.setAdapter(objectsAdapter);

        // Loading Query
        viewModel = ViewModelProviders.of(this).get(ObjectsArrayList.class);
        viewModel.getObjectsArrayListObserver().observe(this, new Observer<ObjectsReturn>() {
            @Override
            public void onChanged(ObjectsReturn objectsReturn) {
                if (objectsReturn != null) {
                    objectsModel = objectsReturn.objectsModelArrayList;
                    sortArray(spinner.getSelectedItemPosition());
                    objectsAdapter.setObjectsArrayList(objectsModel);
                }
            }
        });
        viewModel.loadObjectsList("sushi");

        // Navigation Bar
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {drawerLayout.openDrawer(GravityCompat.START);
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
                        replaceFragment(new FragmentSearch());
                        Toast.makeText(MainActivity.this, "Search Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_favorites:
                        replaceFragment(new FragmentFavorites());
                        Toast.makeText(MainActivity.this, "Favorites Selected", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });

        // Spinner
        spinner = (Spinner) findViewById(R.id.spinner);
        dataAdapter = ArrayAdapter.createFromResource(this, R.array.sorting_array, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int index = parent.getSelectedItemPosition();
                if (position == 0) {
                    if (sortArray(0) != null) {
                        objectsAdapter.updateObjectsArrayList(sortArray(0));
                    }
                } else if (position == 1) {
                    if (sortArray(1) != null) {
                        objectsAdapter.updateObjectsArrayList(sortArray(1));
                    }
                } else {
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        // Searchbar
        searchView = findViewById(R.id.searching_bar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                viewModel.loadObjectsList(query);
                objectsAdapter.clearRestaurantArrayList();
                objectsAdapter.updateObjectsArrayList(objectsModel);
                searchView.clearFocus();
                searchView.setIconified(false);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onObjectsClick(ObjectsModel objects) {
        Toast.makeText(this, "Selected = " + objects.getName(), Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ObjectsModel> sortArray (int sortID) {
        ObjectsModel temp;
        if (objectsModel!=null){
            switch (sortID) {
//                case 0:
//                    for (int i=0; i<objectsModel.size();i++){
//                        for (int j=i+1; j<objectsModel.size();j++){
//                            if (objectsModel.get(i).getPrice() != null && objectsModel.get(j).getPrice() !=null) {
//                                if (objectsModel.get(i).getPrice().length() > objectsModel.get(j).getPrice().length()) {
//                                    temp = objectsModel.get(i);
//                                    objectsModel.set(i, objectsModel.get(j));
//                                    objectsModel.set(j, temp);
//                                }
//                            }
//                        }
//                    }
//                    break;
                case 1:
                    for (int i=0; i<objectsModel.size();i++){
                        for (int j=i+1; j<objectsModel.size();j++){
                            if (objectsModel.get(i).getRating() < objectsModel.get(j).getRating()){
                                temp = objectsModel.get(i);
                                objectsModel.set(i, objectsModel.get(j));
                                objectsModel.set(j, temp);
                            }
                        }
                    }
                    break;
                default:
                    for (int i=0; i<objectsModel.size();i++){
                        for (int j=i+1; j<objectsModel.size();j++){
                            if (objectsModel.get(i).getPrice() != null && objectsModel.get(j).getPrice() !=null) {
                                if (objectsModel.get(i).getPrice().length() > objectsModel.get(j).getPrice().length()) {
                                    temp = objectsModel.get(i);
                                    objectsModel.set(i, objectsModel.get(j));
                                    objectsModel.set(j, temp);
                                }
                            }
                        }
                    }
                    break;
            }
            return  objectsModel;
        } return null;
    }
}