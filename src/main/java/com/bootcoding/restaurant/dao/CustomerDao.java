package com.bootcoding.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDao {
    public void createTable(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres","root");
            Statement stmt=con.createStatement();
            String query="Create table if not exists "
                    +"app_customer"+"( id bigint not null,"
                    +"name text,"
                    +"phone_number decimal,"
                    +"address text,"
                    +"email_id text,"
                    +"city text,"
                    +"state text,"
                    +"create_at timestamp,"
                    +"CONSTRAINT app_customer_pkey PRIMARY KEY (id))";
            stmt.executeUpdate(query);
            System.out.println(query);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
