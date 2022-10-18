package com.bootcoding.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServies {
    public void getData(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres","root");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM emp where sal>=3000");
            while(rs.next()){
                System.out.println("name="+rs.getString("ename"));
                System.out.println("salary="+rs.getLong("sal"));
                System.out.println("deptno="+rs.getLong("deptno"));
                System.out.println("job="+rs.getString("job"));

            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
