package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.model.Customer;
import com.bootcoding.restaurant.model.Vendor;

import java.sql.*;

public class VendorDao {
    private static final String TABLE_NAME = "app_vendor";


    public void createTable(){


        try{
            Class.forName("org.postgresql.Driver");

            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres","root");
            Statement stmt=con.createStatement();
            String query="Create table if not exists " + TABLE_NAME
                    + "( id bigint NOT NULL, "
                    +"name text, "
                    +"phone_number decimal, "
                    +"address text, "
                    +"emailid text, "
                    +"city text, "
                    +"state text, "
                    +"created_at timestamp, "
                    +"pureveg bool,"
                    +"catagary text,"
                    +"rating bigint,"
                    +"CONSTRAINT app_vendor_pkey PRIMARY KEY (id))";
            System.out.println(query);
            stmt.executeUpdate(query);


        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
