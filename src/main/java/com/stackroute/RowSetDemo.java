package com.stackroute;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class RowSetDemo {
    public void displayRow() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();) {
            rowSet.setUrl("jdbc:mysql://localhost:3306/user?useSSL=false");
            rowSet.setUsername("root");
            rowSet.setPassword("Root123");
            rowSet.setCommand("select * from user");
            rowSet.execute();
            while (rowSet.next()) {
                System.out.println("Name: " + rowSet.getString(1) + (" Age: " + rowSet.getString(2)) +
                        (" Gender: " + rowSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
