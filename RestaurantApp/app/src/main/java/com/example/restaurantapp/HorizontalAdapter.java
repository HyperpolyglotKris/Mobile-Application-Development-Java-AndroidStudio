package com.example.restaurantapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>{

    private ArrayList<Classes> classes;

    public HorizontalAdapter(ArrayList<Classes> classes) {
        this.classes = classes;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        Log.e("Testing", "Inside Adapter");
        holder.textView.setText(classes.get(position).getName());
        holder.imageView.setImageResource(classes.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return classes.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public HorizontalViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_name);
            imageView = itemView.findViewById(R.id.item_image);
        }
    }
}
