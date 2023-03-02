package com.example.myrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartAdapter extends ArrayAdapter<Cart> {
    private static final String TAG = "CartAdapter";
    private Context myContext;
    int myResource;


    public CartAdapter(Context context, int resource, ArrayList<Cart> objects) {
        super(context, resource, objects);
        myContext = context;
        myResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        convertView = inflater.inflate(myResource, parent, false);

        String foodName = getItem(position).getFoodName();
        int quantity = getItem(position).getQuantity();
        double foodPrice = getItem(position).getFoodPrice();
        double foodTotal = quantity * foodPrice;



        TextView textCartName = convertView.findViewById(R.id.cartName);
        textCartName.setText(foodName);
        TextView textCartAmount = convertView.findViewById(R.id.cartAmount);
        textCartAmount.setText(""+quantity);
        TextView textCartPrice = convertView.findViewById(R.id.cartPrice);
        DecimalFormat df = new DecimalFormat("0.00");
        textCartPrice.setText(""+df.format(foodPrice));
        TextView textCartTotal = convertView.findViewById(R.id.cartTotal);
        textCartTotal.setText(""+df.format(foodTotal));

        return convertView;
    }
}

