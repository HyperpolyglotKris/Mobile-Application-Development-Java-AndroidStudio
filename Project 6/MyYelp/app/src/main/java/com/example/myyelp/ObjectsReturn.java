package com.example.myyelp;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ObjectsReturn {
    @SerializedName("businesses")
    public ArrayList<ObjectsModel> objectsModelArrayList;
}
