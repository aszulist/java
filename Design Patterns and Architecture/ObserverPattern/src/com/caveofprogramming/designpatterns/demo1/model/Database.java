package com.caveofprogramming.designpatterns.demo1.model;

public class Database {

    private static Database instance = new Database();

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

    public void connect() {
        System.out.println("Connected to database.");
    }

    public void disconnect() {
        System.out.println("Disconnected");
    }

}
