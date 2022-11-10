package com.bootcoding.restaurant.exercise;

public class FactoryPatternClass {
    public static void main(String[] args) {
        RestaurantFactory resf=new RestaurantFactory();
        Restaurant rs=resf.getRestaurant("Veg");
        rs.order();
        Restaurant rs1=resf.getRestaurant("SeaFood");
        rs.order();;
        Restaurant rs2= resf.getRestaurant("Nonveg");
        rs.order();
    }
}
