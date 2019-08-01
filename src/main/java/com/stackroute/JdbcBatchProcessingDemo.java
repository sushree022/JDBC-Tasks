package com.stackroute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatchProcessingDemo {
    public void batchProcessingDemo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (
                ClassNotFoundException e) {
            e.printStackTrace();
        }
//        connecting java application with mysql database

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false",
                "root", "Root123")) {
//            Creation of object of statement
            Statement statement = connection.createStatement();
//            auto-commit is set to false
            connection.setAutoCommit(false);
//            Create SQL statement
            String SQL = "INSERT INTO user (name,age,gender) " + "VALUES('Sudha',50,'F')";
//            Adding above SQL statement in the batch.
            statement.addBatch(SQL);
            SQL = "INSERT INTO user (name,age,gender) " + "VALUES('Sini',55,'M')";
            statement.addBatch(SQL);
//            SQL statement for updation
            SQL = "UPDATE user SET age = 30 " + "WHERE name='PP'";
            statement.addBatch(SQL);
//            To hold returned values
            int[] count = statement.executeBatch();
            System.out.println("no of rows effected " + count);
//            Commit statements to apply changes
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

