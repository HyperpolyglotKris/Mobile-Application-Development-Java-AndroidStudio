package com.example.restaurantapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Cart implements Parcelable {
    private static double totalPrice;
    private String foodName;
    private int quantity;
    private double foodPrice;
    private double foodTotal;

    public Cart (Food food, int quantity){
        this.foodName = food.getName();
        this.quantity = quantity;
        this.foodPrice = food.getPrice();
        this.foodTotal = food.getPrice() * quantity;
        totalPrice = totalPrice + this.foodTotal;
    }

    protected Cart(Parcel in) {
        foodName = in.readParcelable(Food.class.getClassLoader());
        quantity = in.readInt();
    }

    public static final Creator<Cart> CREATOR = new Creator<Cart>() {
        @Override
        public Cart createFromParcel(Parcel in) {
            return new Cart(in);
        }

        @Override
        public Cart[] newArray(int size) {
            return new Cart[size];
        }
    };

    @Override
    public boolean equals(Object object) {
        boolean areEqual = false;
        if (object instanceof Cart) {
            Cart other = (Cart) object;
            areEqual = foodName.equals(other.foodName);
        }
        return areEqual;
    }

    public static void setTotalPrice(double totalPrice) {
        Cart.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public double getFoodTotal() {
        return foodTotal;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setFoodTotal(double foodTotal) {
        this.foodTotal = foodTotal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
