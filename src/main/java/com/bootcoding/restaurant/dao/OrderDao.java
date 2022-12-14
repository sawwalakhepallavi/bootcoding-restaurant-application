package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.model.Customer;
import com.bootcoding.restaurant.model.Order;

import java.sql.*;

public class OrderDao {
    private static final String TABLE_NAME = "app_order";
    private DAOService daoService;
    public OrderDao(){
        daoService = new DAOService();
    }
    public void insertOrderDao(Order order) {

        try {
            Connection con = daoService.getConnection();
            if (!daoService.exists(con, TABLE_NAME, order.getOrderId())) {
                String sql = "INSERT INTO " + TABLE_NAME + " VALUES ( ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setLong(1, order.getOrderId());
                ps.setDouble(2, order.getTotalAmount());
                ps.setLong(3, order.getVendor().getVendorId());
                ps.setLong(4, order.getCustomer().getCustomerId());
                ps.setString(5, order.getDeliveryAddress());
                ps.setTimestamp(6, new Timestamp (order.getOrderDate().getTime()));
                ps.setString(7, order.getOrderStatus());
                ps.executeUpdate();
                System.out.println(order.getOrderId() + " inserted into DB!");
            } else {
                System.out.println(order.getOrderId() + " already exists!");
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
                    +"orderId bigint, "
                    +"totalAmount bigint, "
                    +"vendor_id bigint, "
                    +"customer_id bigint,"
                    +"deliveryAddress text, "
                    +"created_at timestamp, "
                    +"orderStatus text, "
                    +"CONSTRAINT app_order_pkey PRIMARY KEY (id))";
            System.out.println(query);
            stmt.executeUpdate(query);


        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
