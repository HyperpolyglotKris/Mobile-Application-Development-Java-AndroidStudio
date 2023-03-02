package com.example.foodies;

import java.util.ArrayList;
import java.util.UUID;

public class DataSource {

    private static ArrayList<Restaurant> restaurantData = setUpMockData();

    private static ArrayList<Restaurant> setUpMockData () {

        ArrayList<Restaurant> restaurantList = new ArrayList<>();

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setUuid(UUID.randomUUID().toString());
        restaurant1.setName("Fishu");
        restaurant1.setAddress1("Sherbrooke");
        restaurant1.setCity("Montreal");
        restaurant1.setPostalCode("H4G XXG");
        restaurant1.setMinPrice(5);
        restaurant1.setMaxPrice(40);
        restaurant1.setRating(5.0);
        restaurant1.setBannerImage(R.drawable.fishu);
        restaurant1.setDeliveryFee(0.99);
        restaurant1.setVegetarian(true);
        restaurant1.setDeliveryTime("25-35");
        restaurantList.add(restaurant1);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setUuid(UUID.randomUUID().toString());
        restaurant2.setName("Poulet Rougeee");
        restaurant2.setAddress1("Saint-Catherine");
        restaurant2.setCity("Montreal");
        restaurant2.setPostalCode("H4G XXG");
        restaurant2.setMinPrice(10);
        restaurant2.setMaxPrice(50);
        restaurant2.setDeliveryFee(1.99);
        restaurant2.setDeliveryTime("20-35");
        restaurant2.setBannerImage(R.drawable.poulet_rouge);
        restaurant2.setRating(4.0);
        restaurantList.add(restaurant2);


        Restaurant restaurant3 = new Restaurant();
        restaurant3.setUuid(UUID.randomUUID().toString());
        restaurant3.setName("Five Guyss");
        restaurant3.setAddress1("Rue Ottawa");
        restaurant3.setCity("Laval");
        restaurant3.setPostalCode("H4G XXG");
        restaurant3.setMinPrice(20);
        restaurant3.setMaxPrice(100);
        restaurant3.setFeatured(true);
        restaurant3.setDeliveryFee(2.99);
        restaurant3.setDeliveryTime("20-40");
        restaurant3.setBannerImage(R.drawable.five_guys);
        restaurant3.setRating(2.0);
        restaurantList.add(restaurant3);


        Restaurant restaurant4 = new Restaurant();
        restaurant4.setUuid(UUID.randomUUID().toString());
        restaurant4.setName("Mandy's");
        restaurant4.setAddress1("Rue Galt");
        restaurant4.setCity("Verdun");
        restaurant4.setPostalCode("H4G XXG");
        restaurant4.setMinPrice(10);
        restaurant4.setMaxPrice(50);
        restaurant4.setFeatured(true);
        restaurant4.setBannerImage(R.drawable.mandy);
        restaurant4.setDeliveryFee(0.99);
        restaurant4.setDeliveryTime("25-45");
        restaurant4.setRating(3.5);
        restaurantList.add(restaurant4);

        Restaurant restaurant5 = new Restaurant();
        restaurant5.setUuid(UUID.randomUUID().toString());
        restaurant5.setName("Ajit's Palace");
        restaurant5.setAddress1("Rue Guy");
        restaurant5.setCity("Montreal");
        restaurant5.setPostalCode("H4G XXG");
        restaurant5.setMinPrice(100);
        restaurant5.setMaxPrice(400);
        restaurant5.setBannerImage(R.drawable.ajit);
        restaurant5.setRating(4.5);
        restaurant5.setFeatured(true);
        restaurant5.setDeliveryFee(3.99);
        restaurant5.setDeliveryTime("25-35");
        restaurantList.add(restaurant5);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setUuid(UUID.randomUUID().toString());
        restaurant6.setName("Taco Taco");
        restaurant6.setAddress1("Rue Marc");
        restaurant6.setCity("Verdun");
        restaurant6.setPostalCode("H4G XXG");
        restaurant6.setMinPrice(10);
        restaurant6.setMaxPrice(25);
        restaurant6.setVegetarian(true);
        restaurant6.setBannerImage(R.drawable.vegan);
        restaurant6.setRating(3.0);
        restaurant6.setDeliveryFee(4.99);
        restaurant6.setDeliveryTime("10-20");
        restaurantList.add(restaurant6);

        Restaurant restaurant7 = new Restaurant();
        restaurant7.setUuid(UUID.randomUUID().toString());
        restaurant7.setName("McDonald's");
        restaurant7.setAddress1("Rue Woodland");
        restaurant7.setCity("Montreal");
        restaurant7.setPostalCode("H4G XXG");
        restaurant7.setMinPrice(10);
        restaurant7.setMaxPrice(67);
        restaurant7.setBannerImage(R.drawable.mcd);
        restaurant7.setRating(2.0);
        restaurant7.setDeliveryFee(0.99);
        restaurant7.setDeliveryTime("20-25");
        restaurantList.add(restaurant7);

        Restaurant restaurant8 = new Restaurant();
        restaurant8.setUuid(UUID.randomUUID().toString());
        restaurant8.setName("Omnivore");
        restaurant8.setAddress1("De Maisonneuve");
        restaurant8.setCity("Montreal");
        restaurant8.setPostalCode("H4G XXG");
        restaurant8.setMinPrice(10);
        restaurant8.setMaxPrice(90);
        restaurant8.setBannerImage(R.drawable.featured_img1);
        restaurant8.setRating(1.5);
        restaurant8.setDeliveryFee(3.99);
        restaurant8.setDeliveryTime("20-40");
        restaurant8.setVegetarian(true);
        restaurantList.add(restaurant8);

        Restaurant restaurant9 = new Restaurant();
        restaurant9.setUuid(UUID.randomUUID().toString());
        restaurant9.setName("Pizza Home");
        restaurant9.setAddress1("Rue Chomedy");
        restaurant9.setCity("Longueuil");
        restaurant9.setPostalCode("H4G XXG");
        restaurant9.setMinPrice(10);
        restaurant9.setMaxPrice(40);
        restaurant9.setBannerImage(R.drawable.pizza);
        restaurant9.setRating(4.0);
        restaurant9.setDeliveryFee(5.99);
        restaurant9.setDeliveryTime("10-25");
        restaurantList.add(restaurant9);

        Restaurant restaurant10 = new Restaurant();
        restaurant10.setUuid(UUID.randomUUID().toString());
        restaurant10.setName("One Burger");
        restaurant10.setAddress1("Saint Marc");
        restaurant10.setCity("Nuns Island");
        restaurant10.setPostalCode("H4G XXG");
        restaurant10.setMinPrice(1);
        restaurant10.setMaxPrice(30);
        restaurant10.setFeatured(true);
        restaurant10.setBannerImage(R.drawable.burger);
        restaurant10.setRating(3.9);
        restaurant10.setDeliveryFee(0.99);
        restaurant10.setDeliveryTime("10-15");
        restaurantList.add(restaurant10);

        return restaurantList;
    }

    public static ArrayList<Restaurant> getRestaurantList() {
        return restaurantData;
    }


}
