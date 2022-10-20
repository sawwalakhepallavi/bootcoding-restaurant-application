package com.bootcoding.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOService {
    public Connection getConnection(){
        try{
            // 1. Load JDBC Driver
            Class.forName("org.postgresql.Driver");
            // 2. Establish Connection with your local database
            Connection con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "root");
            return con;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
