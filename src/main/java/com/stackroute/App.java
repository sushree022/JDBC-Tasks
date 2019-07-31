package com.stackroute;

import java.sql.ResultSetMetaData;

//Class having main method
public class App {
    public static void main(String[] args) {
//        instance of JdbcBasicDemo class
        JdbcBasicDemo jdbcBasicDemo = new JdbcBasicDemo();
//        To get details from database
        jdbcBasicDemo.displayUser();
//        To get details according to name
        jdbcBasicDemo.getUserByName("PP");
//        instance of database metadata demo class
        DataBaseMetaDataDemo metaData = new DataBaseMetaDataDemo();
        metaData.displayMetaData();
//        instance of resultset meta data demo class
        ResultSetMetaDataDemo resultMetaData= new ResultSetMetaDataDemo();
        resultMetaData.displayResultMetaData();

    }
}
