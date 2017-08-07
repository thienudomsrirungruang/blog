package com.thien.dao;

import java.sql.*;

public class ContentDao {
    private static ContentDao dao;
    private Connection connection;

    private static final String GET_CONTENT_SQL = "select * from posts order by last_mnt_date desc;";
    private static final String GET_CONTENT_BY_ID_SQL = "select * from posts where id = ?";
    private static final String GET_CONTENT_IN_RANGE_SQL = "select * from posts order by last_mnt_date desc limit ?, ?";

    private PreparedStatement getContentSqlStatement;
    private PreparedStatement getContentByIdSqlStatement;
    private PreparedStatement getContentInRangeSqlStatement;

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
            getContentByIdSqlStatement = connection.prepareStatement(GET_CONTENT_BY_ID_SQL);
            getContentInRangeSqlStatement = connection.prepareStatement(GET_CONTENT_IN_RANGE_SQL);
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

    public ResultSet getContentById(int id){
        try{
            getContentByIdSqlStatement.setInt(1, id);
            return getContentByIdSqlStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getContentInRange(int start, int numberOfItems){
        try {
            getContentInRangeSqlStatement.setInt(1, start);
            getContentInRangeSqlStatement.setInt(2, numberOfItems);
            return getContentInRangeSqlStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
