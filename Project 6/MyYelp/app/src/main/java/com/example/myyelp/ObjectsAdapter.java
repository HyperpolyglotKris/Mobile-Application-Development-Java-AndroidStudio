package com.example.myyelp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;
import java.util.List;

public class ObjectsAdapter extends RecyclerView.Adapter<ObjectsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<ObjectsModel> objectsArrayList;
    private ItemClickListener onclickListener;

    public ObjectsAdapter(Context context, ArrayList<ObjectsModel> objectsArrayList, ItemClickListener onclickListener) {
        this.context = context;
        this.objectsArrayList = objectsArrayList;
        this.onclickListener = onclickListener;
    }

    public void setObjectsArrayList(ArrayList<ObjectsModel> objectsArrayList) {
        this.objectsArrayList = objectsArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ObjectsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.adater_layout, parent, false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjectsAdapter.MyViewHolder holder, int pos) {

        ObjectsModel objectsModel = this.objectsArrayList.get(pos);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        Glide.with(context).load(this.objectsArrayList.get(pos).getImageUrl()).apply(RequestOptions.centerInsideTransform()).into(holder.image);
        // Name
        if (objectsModel.getName() != null) {myViewHolder.name.setText(objectsModel.getName());}
        // Price
        if (objectsModel.getPrice() != null) {
            myViewHolder.price.setText("" + objectsModel.getPrice());}
        else {myViewHolder.price.setText("");
        objectsModel.setPrice("");}
        // Category
        if (objectsModel.getCategory() != null) {
            myViewHolder.category.setText("" + objectsModel.getCategory());}
        // Phone
        if (objectsModel.getPhone() != null) {
            myViewHolder.phone.setText("" + objectsModel.getPhone());}
        // Address
        if (objectsModel.getDisplayAddress() != null) {
            myViewHolder.address.setText("" + objectsModel.getDisplayAddress());}
        // Rating
        Float rating = objectsModel.getRating() != null ? objectsModel.getRating().floatValue() : Float.valueOf("0.0");
        myViewHolder.rating.setRating(rating);
    }

    @Override
    public int getItemCount() {
        if (this.objectsArrayList != null) {
            return this.objectsArrayList.size();
        }
        return 0;
    }

    public void clearRestaurantArrayList() {
        this.objectsArrayList.clear();
    }

    public void updateObjectsArrayList(final List<ObjectsModel> objectsArrayList) {
        this.objectsArrayList = (ArrayList<ObjectsModel>) objectsArrayList;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        RatingBar rating;
        TextView price;
        TextView category;
        TextView phone;
        TextView address;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            rating = (RatingBar) itemView.findViewById(R.id.rating_bar);
            price = (TextView) itemView.findViewById(R.id.price);
            category = (TextView) itemView.findViewById(R.id.category);
            address = (TextView) itemView.findViewById(R.id.address);
            phone = (TextView) itemView.findViewById(R.id.phone);
        }
    }

    public interface ItemClickListener {
        public void onObjectsClick(ObjectsModel objectsModel);
    }
}
