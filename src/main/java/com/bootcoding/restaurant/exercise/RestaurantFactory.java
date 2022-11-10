package com.bootcoding.restaurant.exercise;

public class RestaurantFactory {
    public Restaurant getRestaurant(String restaurantType){
        if(restaurantType==null){
            return null;
        }
        if(restaurantType.equalsIgnoreCase("veg")){
            return new NonvegRestaurant();
        }
        if(restaurantType.equalsIgnoreCase("Nonveg")){
            return  new NonvegRestaurant();
        }
        if (restaurantType.equalsIgnoreCase("Seafood")){
            return new SeaFoodRestaurant();
        }
        return null;
    }
}
