package com.example.restaurantapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class FoodListAdapter extends ArrayAdapter<Food> {
    private static final String TAG = "FoodListAdapter";
    private Context myContext;
    int myResource;

    public FoodListAdapter(Context context, int resource, ArrayList<Food> objects) {
        super(context, resource, objects);
        myContext = context;
        myResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int id = getItem(position).getId();
        String name = getItem(position).getName();
        String description = getItem(position).getDescription();
        int image = getItem(position).getImage();
        double price = getItem(position).getPrice();

        Food food = new Food(id, name, description, image, price);

        LayoutInflater inflater = LayoutInflater.from(myContext);
        convertView = inflater.inflate(myResource, parent, false);

        TextView textViewName =  convertView.findViewById(R.id.textView);
        textViewName.setText(name);

        return convertView;
    }
}