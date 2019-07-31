package com.stackroute;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseMetaDataDemo {
    public void displayMetaData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false",
                "root", "Root123");) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("Driver Name= " + metaData.getDriverName());
            System.out.println("Driver Version= " + metaData.getDriverVersion());
            System.out.println("User Name= " + metaData.getUserName());
            System.out.println("Maximum Columns= " + metaData.getMaxColumnsInIndex());
            System.out.println("Database product Name= " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version" + metaData.getDatabaseProductVersion());
            System.out.println("Catalogs= " + metaData.getCatalogs());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
