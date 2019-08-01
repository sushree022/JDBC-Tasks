package com.stackroute;

import java.sql.*;

public class JdbcTransactionDemo {
    public void jdbcTransaction() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        connecting java application with mysql database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false",
                "root", "Root123")) {
//            Creation of object of statement
            Statement statement = connection.createStatement();
//            auto-commit is set to false
            connection.setAutoCommit(false);
//            creation of sql statements
            statement.executeUpdate("insert into user values('Lipu',26,'M')");
            statement.executeUpdate("insert into user values('Jigul',5,'Female')");
//            commit statements to apply changes
            connection.commit();
            ResultSet resultSet = statement.executeQuery("select * from user");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

