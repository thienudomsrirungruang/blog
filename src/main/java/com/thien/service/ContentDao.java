package com.thien.service;

import java.sql.*;

public class ContentDao {
    private static ContentDao dao;
    private Connection connection;


    private static ContentDao getInstance(){
        if(dao == null){
            dao = new ContentDao();
        }
        return dao;
    }

    public ContentDao(){
        connection = getConnection();
//        try {
//            // prepare statements
//        } catch (SQLException e) {
//            System.out.println("PrepareStatement failure");
//        }
    }

    protected Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scrabble?useSSL=false", "thien","1234567890");
        } catch (SQLException e) {
            System.out.println("Failed to get connection");
        }

        if(null == connection){
            System.out.println("Connection is null");
        }

        return connection;
    }
}
