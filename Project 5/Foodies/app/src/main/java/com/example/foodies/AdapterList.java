package com.example.foodies;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterList extends ArrayAdapter<Restaurant> {
    private Context myContext;
    int myResource;


    public AdapterList(Context context, int resource, ArrayList<Restaurant> objects) {
        super(context, resource, objects);
        myContext = context;
        myResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        convertView = inflater.inflate(myResource, parent, false);

        String uuid = getItem(position).getUuid();
        String name =getItem(position).getName();
        String address1 = getItem(position).getAddress1();
        String address2 =getItem(position).getAddress2();
        String city = getItem(position).getCity();
        String province = getItem(position).getProvince();
        String postalCode = getItem(position).getPostalCode();
        int minPrice = getItem(position).getMinPrice();
        int maxPrice = getItem(position).getMaxPrice();
        double deliveryFee = getItem(position).getDeliveryFee();
        String deliveryTime = getItem(position).getDeliveryTime();
        boolean isFeatured = getItem(position).isFeatured();
        int bannerImage = getItem(position).getBannerImage();
        Double rating = getItem(position).getRating();
        boolean isVegetarian = getItem(position).isVegetarian();

        ImageView listImage = convertView.findViewById(R.id.list_image);
        listImage.setImageResource(bannerImage);
        TextView listName = convertView.findViewById(R.id.list_name);
        listName.setText(name+", ");
        TextView listAddress = convertView.findViewById(R.id.list_address);
        listAddress.setText(address1+", ");
        TextView listCity = convertView.findViewById(R.id.list_city);
        listCity.setText(city);
        TextView listRating = convertView.findViewById(R.id.list_rating);
        listRating.setText("" + rating);
        TextView listVegetarian = convertView.findViewById(R.id.list_vegetarian);
        if (isVegetarian) {
            listVegetarian.setBackgroundColor(Color.parseColor("#FF00FF00"));
        } else {
            listVegetarian.setTextSize(TypedValue.COMPLEX_UNIT_SP, 4);
            listVegetarian.setText("");
            listVegetarian.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            listVegetarian.setTextColor(Color.parseColor("#FFFFFFFF"));
        }
        TextView listDeliveryFee = convertView.findViewById(R.id.list_delivery_fee);
        listDeliveryFee.setText("$"+deliveryFee+ " Delivery Fee^");
        TextView listDeliveryTime = convertView.findViewById(R.id.list_delivery_time);
        listDeliveryTime.setText("- "+ deliveryTime+" min");

        return convertView;


    }
}
