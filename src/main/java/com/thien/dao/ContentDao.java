package com.thien.dao;

import java.sql.*;

public class ContentDao {
    private static ContentDao dao;
    private Connection connection;

    private static final String GET_CONTENT_SQL = "select * from previews;";

    private PreparedStatement getContentSqlStatement;

    public static ContentDao getInstance(){
        if(dao == null){
            dao = new ContentDao();
        }
        return dao;
    }

    public ContentDao(){
        connection = getConnection();
        try {
            getContentSqlStatement = connection.prepareStatement(GET_CONTENT_SQL);
        } catch (SQLException e) {
            System.out.println("PreparedStatement failure");
        }
    }

    protected Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/blog?useSSL=false", "username","password");
        } catch (SQLException e) {
            System.out.println("Failed to get connection");
        }

        if(null == connection){
            System.out.println("Connection is null");
        }

        return connection;
    }

    public ResultSet getContent(){
        try {
            ResultSet rs = getContentSqlStatement.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
