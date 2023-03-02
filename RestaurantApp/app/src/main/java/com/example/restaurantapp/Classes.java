package com.example.restaurantapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Classes implements Parcelable {
    private String name;
    private int image;

    public String getName(){
        return this.name;
    }

    public int getImage(){
        return this.image;
    }

    public Classes(String name, int image) {
        this.name = name;
        this.image = image;
    }

    protected Classes(Parcel in) {
        name = in.readString();
        image = in.readInt();
    }

    public static final Creator<Classes> CREATOR = new Creator<Classes>() {
        @Override
        public Classes createFromParcel(Parcel in) {
            return new Classes(in);
        }

        @Override
        public Classes[] newArray(int size) {
            return new Classes[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(image);
    }
}
