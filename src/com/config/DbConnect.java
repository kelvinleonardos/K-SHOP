package com.config;

import java.sql.*;


public class DbConnect {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_products";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    protected static Connection connection;
    protected static PreparedStatement preparedStatement;
    protected static Statement statement;
    protected static ResultSet resultSet;
    protected static String query;

    protected static void connection() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
