package com.stackroute;

import java.sql.*;

public class ResultSetMetaDataDemo {
    public void displayResultMetaData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false",
                "root", "Root123");
             PreparedStatement statement = connection.prepareStatement("Select * from user");
             ResultSet resultSet = statement.executeQuery()) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println("Total coloumns: " + metaData.getColumnCount());
            System.out.println("Column Name of first column: " + metaData.getColumnName(1));
            System.out.println("Column Name of second column: " + metaData.getColumnTypeName(1));
            System.out.println("Column Name of first column: " + metaData.getColumnName(2));
            System.out.println("Column Name of second column: " + metaData.getColumnTypeName(2));
            System.out.println("Column Name of first column: " + metaData.getColumnName(3));
            System.out.println("Column Name of second column: " + metaData.getColumnTypeName(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
