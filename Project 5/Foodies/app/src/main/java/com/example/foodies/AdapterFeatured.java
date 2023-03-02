package com.example.foodies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterFeatured extends RecyclerView.Adapter<AdapterFeatured.MyViewHolder> {
    private Context context;
    private ArrayList<Restaurant> restaurantArrayList;

    public AdapterFeatured(Context context, ArrayList<Restaurant> restaurantArrayList) {
        this.context = context;
        this.restaurantArrayList = restaurantArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_featured, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFeatured.MyViewHolder holder, int position) {
            holder.featuredName.setText(restaurantArrayList.get(position).getName());
            holder.featuredAddress.setText(restaurantArrayList.get(position).getAddress1());
            holder.featuredImage.setImageResource(restaurantArrayList.get(position).getBannerImage());
    }

    @Override
    public int getItemCount() {
        return restaurantArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView featuredName;
        TextView featuredAddress;
        ImageView featuredImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            featuredName = itemView.findViewById(R.id.featured_name);
            featuredAddress = itemView.findViewById(R.id.featured_address);
            featuredImage = itemView.findViewById(R.id.featured_image);
        }
    }
}