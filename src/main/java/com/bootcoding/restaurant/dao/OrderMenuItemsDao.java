package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.model.Customer;

import java.sql.*;

public class OrderMenuItemsDao {
    private static final String TABLE_NAME = "app_orderMenuItems";

    public void createCustomer(Customer customer){

        try{
            Class.forName("org.postgresql.Driver");

            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres","root");

            PreparedStatement stmt = con.prepareStatement("insert into " + TABLE_NAME
                    + " VALUES (?,?,?,?,?,?,?,?)");
            stmt.setLong(1, customer.getCustomerId());
            stmt.setString(2, customer.getName());
            stmt.setLong(3, customer.getPhonenumber());
            stmt.setString(4, customer.getAddress());
            stmt.setString(5, customer.getEmailId());
            stmt.setString(6, customer.getCity());
            stmt.setString(7, customer.getState());
            stmt.setTimestamp(8, new Timestamp(customer.getCreatedAt().getTime()));

            stmt.executeUpdate();

            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void createTable(){


        try{
            Class.forName("org.postgresql.Driver");

            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres","root");
            Statement stmt=con.createStatement();
            String query="Create table if not exists " + TABLE_NAME
                    + "( id bigint NOT NULL, "
                    +"menuItem text, "
                    +"quantity int, "
                    +"price decimal, "
                    +"isVeg bigint,"
                    +"CONSTRAINT app_orderMenuItems_pkey PRIMARY KEY (id))";
            System.out.println(query);
            stmt.executeUpdate(query);


        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
