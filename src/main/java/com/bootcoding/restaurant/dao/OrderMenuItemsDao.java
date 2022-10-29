package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.model.Customer;
import com.bootcoding.restaurant.model.OrderMenuItems;

import java.sql.*;

public class OrderMenuItemsDao {
    private static final String TABLE_NAME = "app_orderMenuItems";
    private DAOService daoService;

    public OrderMenuItemsDao() {
        daoService = new DAOService();
    }

    public void insertOrderMenuItemsDao(OrderMenuItems orderMenuItems) {

        try {
            Connection con = daoService.getConnection();
            if (!daoService.exists(con, TABLE_NAME, orderMenuItems.getMenuItemId())) {
                String sql = "INSERT INTO " + TABLE_NAME + " VALUES ( ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setLong(1, orderMenuItems.getMenuItemId());
                ps.setLong(2, orderMenuItems.getOrderId());
                ps.setString(3, orderMenuItems.getMenuItem());
                ps.setInt(4, orderMenuItems.getQuantity());
                ps.setDouble(5, orderMenuItems.getPrice());
                ps.setBoolean(6, orderMenuItems.isVeg());
                ps.executeUpdate();
                System.out.println(orderMenuItems.getMenuItemId() + " inserted into DB!");
            } else {
                System.out.println(orderMenuItems.getMenuItemId() + " already exists!");
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
                    +"order_Id bigint, "
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
