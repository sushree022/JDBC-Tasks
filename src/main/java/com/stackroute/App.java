package com.stackroute;

//Class having main method
public class App {
    public static void main(String[] args) {
//        instance of JdbcBasicDemo class
        JdbcBasicDemo jdbcBasicDemo = new JdbcBasicDemo();
//        To get details from database
        jdbcBasicDemo.displayUser();
//        To get details according to name
        jdbcBasicDemo.getUserByName("PP");
    }
}
