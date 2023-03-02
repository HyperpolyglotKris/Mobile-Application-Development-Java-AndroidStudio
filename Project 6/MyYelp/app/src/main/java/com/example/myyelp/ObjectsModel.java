package com.example.myyelp;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class ObjectsModel {
    private String name;
    private Double rating;
    private String price;
    private List categories;
    private String categories_str;
    private String phone;
    private String address;
    private Map location;
    private String image_url;
    private String city;
    private String title;

    // Constructors
    public String getName() {
        return this.name;
    }
    public Double getRating() {
        return this.rating;
    }
    public String getPrice() {
        return this.price;
    }
    public String getCategory() {
        List categories_list = this.categories;
        categories_str = "";
        for (int i=0; 1<categories.size();i++){
            Map categories_map = (Map) categories_list.get(i);
            categories_str = categories_str + "" + (String) categories_map.get("title");
            return this.categories_str;
        }
        return categories_str;
    }
    public String getPhone() {
        return this.phone;
    }
    public String getImageUrl() {
        return this.image_url;
    }
    public String getDisplayAddress() {
        List<String> address = (List) this.location.get("display_address");
        return address.toString().substring(1,address.toString().length()-1);
    }

    public void setPrice (String s) {
        this.price = s;
    }
}

