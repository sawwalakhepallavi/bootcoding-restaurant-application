package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.model.Customer;
import com.bootcoding.restaurant.model.Vendor;

import java.sql.*;

public class VendorDao {
    private static final String TABLE_NAME = "app_vendor";
    private DAOService daoService;
    public VendorDao(){
        daoService = new DAOService();
    }
    public void insertVendorDao(Vendor vendor) {

        try {
            Connection con = daoService.getConnection();
            if (!daoService.exists(con, TABLE_NAME, vendor.getVendorId())) {
                String sql = "INSERT INTO " + TABLE_NAME + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setLong(1, vendor.getVendorId());
                ps.setString(2, vendor.getName());
                ps.setLong(3, vendor.getPhoneNumber());
                ps.setString(4, vendor.getAddress());
                ps.setString(5, vendor.getEmailId());
                ps.setString(6, vendor.getCity());
                ps.setString(7, vendor.getState());
                ps.setBoolean(8, vendor.isPureVeg());
                ps.setString(9, vendor.getCategory());
                ps.setDouble(10, vendor.getRating());
                ps.executeUpdate();
                System.out.println(vendor.getVendorId() + " inserted into DB!");
            } else {
                System.out.println(vendor.getVendorId() + " already exists!");
            }
            con.close();
        } catch (Exception ex) {
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
                    +"name text, "
                    +"phone_number decimal, "
                    +"address text, "
                    +"emailId text, "
                    +"city text, "
                    +"state text, "
                    +"pureVeg bool,"
                    +"category text,"
                    +"rating bigint,"
                    +"CONSTRAINT app_vendor_pkey PRIMARY KEY (id))";
            System.out.println(query);
            stmt.executeUpdate(query);


        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
