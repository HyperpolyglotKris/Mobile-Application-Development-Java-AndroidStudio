package com.example.myrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class FoodDetailAdapter extends ArrayAdapter<Food> {
    private static final String TAG = "FoodDetailAdapter";
    private Context myContext;
    int myResource;

    public FoodDetailAdapter(Context context, int resource, ArrayList<Food> objects) {
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

        ImageView imageView = convertView.findViewById(R.id.itemImage);
        imageView.setImageResource(image);
        TextView textViewName =  convertView.findViewById(R.id.itemName);
        textViewName.setText(name);
        TextView textViewDescription = convertView.findViewById(R.id.itemDescription);
        textViewDescription.setText(description);
        TextView textViewPrice = convertView.findViewById(R.id.itemPrice);
        textViewPrice.setText("" + price);

        return convertView;
    }
}
