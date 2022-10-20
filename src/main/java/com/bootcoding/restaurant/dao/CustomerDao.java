package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.model.Customer;

import java.sql.*;

public class CustomerDao {
    private static final String TABLE_NAME = "app_customer";

    private DAOService daoService;
    public CustomerDao(){
        daoService = new DAOService();
    }
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

            Connection con = daoService.getConnection();
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
                    +"CONSTRAINT app_customer_pkey PRIMARY KEY (id))";
            System.out.println(query);
            stmt.executeUpdate(query);


        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
