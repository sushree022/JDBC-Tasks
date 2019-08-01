package com.stackroute;

import java.sql.*;

public class JdbcBasicDemo {
    public void displayUser() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        connecting java application with mysql database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false",
                "root", "Root123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from user");) {
            while (resultSet.next()) {
                System.out.println(" Name: " + resultSet.getString(1) + " Age: " + resultSet.getInt(2) +
                        " Gender: " + resultSet.getString(3));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void getUserByName(String name) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false", "root", "Root123");) {
            PreparedStatement statement = connection.prepareStatement("Select * from user where name= ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Age: " + resultSet.getInt(2) +
                        " Gender: " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

