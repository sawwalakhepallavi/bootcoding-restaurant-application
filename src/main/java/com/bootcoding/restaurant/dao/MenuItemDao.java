package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.model.Customer;
import com.bootcoding.restaurant.model.MenuItem;

import java.sql.*;

public class MenuItemDao {
    private static final String TABLE_NAME = "app_menuItem";
    private DAOService daoService;
    public MenuItemDao(){
        daoService = new DAOService();
    }
    public void insertMenuItemDao(MenuItem menuItem) {

        try {
            Connection con = daoService.getConnection();
            if (!daoService.exists(con, TABLE_NAME, menuItem.getMenuItemId())) {
                String sql = "INSERT INTO " + TABLE_NAME + " VALUES ( ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setLong(1, menuItem.getMenuItemId());
                ps.setLong(2, menuItem.getVendorId());
                ps.setString(3, menuItem.getMenuItem());
                ps.setDouble(4, menuItem.getPrice());
                ps.setString(5, menuItem.getCategory());
                ps.setBoolean(6, menuItem.isVeg());
                ps.executeUpdate();
                System.out.println(menuItem.getMenuItemId() + " inserted into DB!");
            } else {
                System.out.println(menuItem.getMenuItemId() + " already exists!");
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    public void createTable() {


        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "root");
            Statement stmt = con.createStatement();
            String query = "Create table if not exists " + TABLE_NAME
                    + "( id bigint NOT NULL, "
                    + "vendor_id bigint, "
                    + "menuItem text, "
                    + "price decimal, "
                    + "category text, "
                    + "isVeg bool, "
                    + "CONSTRAINT app_menuItem_pkey PRIMARY KEY (id))";
            System.out.println(query);
            stmt.executeUpdate(query);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}