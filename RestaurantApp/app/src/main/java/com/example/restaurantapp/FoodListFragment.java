package com.example.restaurantapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodListFragment extends Fragment {
    View view;
    ArrayList<Food> database;
    String databaseName;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_food_list, container, false);

        int id = getArguments().getInt("CategoryID");

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

        ListView listView = (ListView) view.findViewById(R.id.listView);
        FoodListAdapter adapter = new FoodListAdapter(getContext(), R.layout.adapter_view_layout, database);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = position +1;
                Log.e("Testing", ""+pos);
                Log.e("Testing", databaseName);
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("FoodID", pos);
                intent.putExtra("FoodList", databaseName);
                ((MainActivity) getActivity()).startActivity(intent);
            }
        });

        return view;
    }
}