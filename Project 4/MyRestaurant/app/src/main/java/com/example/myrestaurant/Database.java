package com.example.myrestaurant;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Database implements Parcelable {

    // RAMEN DATABASE
    static Food ramen1 = new Food(1, "Chicken Ramen", "Japanese Ramen soup with chicken, containing vegetable broth, seaweed, egg and homemade noodles.", R.drawable.ramen1, 14.99);
    static Food ramen2 = new Food(2, "Beef Ramen", "Japanese Ramen soup with beef, containing vegetable broth, seaweed, egg and homemade noodles.", R.drawable.ramen2, 14.99);
    static Food ramen3 = new Food(3, "Pork Ramen", "Japanese Ramen soup with pork, containing vegetable broth, seaweed, egg and homemade noodles.", R.drawable.ramen3, 14.99);

    static ArrayList<Food> ramenList = new ArrayList<>();
    static {
        ramenList.add(ramen1);
        ramenList.add(ramen2);
        ramenList.add(ramen3);
    }

    // DUMPLINGS DATABASE
    static Food dumplings1 = new Food(1, "Pork and Vegetables", "Chinese dumplings filled with Pork and Vegetables", R.drawable.dumplings1, 10.99);
    static Food dumplings2 = new Food(2, "Beef and Vegetables", "Chinese dumplings filled with Beef and Vegetables.", R.drawable.dumplings2, 10.99);
    static Food dumplings3 = new Food(3, "Chicken and Vegetables", "Chinese dumplings filled with Chicken and Vegetables.", R.drawable.dumplings3, 10.99);
    static Food dumplings4 = new Food(4, "Tofu and Vegetables", "Chinese dumplings filled with Tofu and Vegetables", R.drawable.dumplings4, 10.99);

    static ArrayList<Food> dumplingsList = new ArrayList<>();
    static {
        dumplingsList.add(dumplings1);
        dumplingsList.add(dumplings2);
        dumplingsList.add(dumplings3);
        dumplingsList.add(dumplings4);
    }

    // SUSHI DATABASE
    static Food sushi1 = new Food(1, "Nigiri Sushi", "Nigiri Sushi with Salmon fish and rice", R.drawable.sushi1, 6.99);
    static Food sushi2 = new Food(2, "Tobiko Sushi", "Tobiko sushi topped with caviar", R.drawable.sushi2, 6.99);
    static Food sushi3 = new Food(3, "Vegetarian sushi", "Vegetarian sushi with cucumber, avocado and carrot", R.drawable.sushi3, 6.99);
    static Food sushi4 = new Food(4, "Maki Roll Sushi", "Sushi with salmon, cucumber and cream cheese", R.drawable.sushi4, 6.99);
    static Food sushi5 = new Food(5, "California Roll", "California roll sushi with avocado and crab", R.drawable.sushi5, 6.99);

    static ArrayList<Food> sushiList = new ArrayList<>();
    static {
        sushiList.add(sushi1);
        sushiList.add(sushi2);
        sushiList.add(sushi3);
        sushiList.add(sushi4);
        sushiList.add(sushi5);
    }

    // BUBBLE TEA DATABASE
    static Food bubbleTea1 = new Food(1, "Green Tea", "Green tea and milk with Tapioca", R.drawable.bubbletea1, 5.99);
    static Food bubbleTea2 = new Food(2, "Black Tea", "Black tea and milk with Tapioca", R.drawable.bubbletea2, 5.99);
    static Food bubbleTea3 = new Food(3, "Fresh Milk", "Fresh Milk and Tapioca BubbleTea", R.drawable.bubbletea3, 5.99);

    static ArrayList<Food> bubbleTeaList = new ArrayList<>();
    static {
        bubbleTeaList.add(bubbleTea1);
        bubbleTeaList.add(bubbleTea2);
        bubbleTeaList.add(bubbleTea3);
    }

    protected Database(Parcel in) {
    }

    public static final Creator<Database> CREATOR = new Creator<Database>() {
        @Override
        public Database createFromParcel(Parcel in) {
            return new Database(in);
        }

        @Override
        public Database[] newArray(int size) {
            return new Database[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
