package com.caveofprogramming.designpatterns.demo1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance = new Database();

    private Connection con;

    private Database() {

    }

    public static Database getInstance() {
        return instance;
    }

    /*
    private static Database instanceold;

    public static Database getInstanceOld() {

        if(instanceold == null) {
            instanceold = new Database();
        }
        return instanceold;
    }
    */

    public void connect() throws Exception {
        if (con != null) {
            return;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found");
        }

        String url = String.format("jdbc:mysql://localhost:%d", 3306);

        con = DriverManager.getConnection(url, "squiffy", "letmein");
    }

    public void disconnect() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Can't close connection");
            }
        }
    }

}
