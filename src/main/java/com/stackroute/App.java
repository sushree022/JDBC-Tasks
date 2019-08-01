package com.stackroute;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

//Class having main method
public class App {
    public static void main(String[] args) throws SQLException {
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
//        instance of row set demo class
        RowSetDemo rowSetDemo= new RowSetDemo();
        rowSetDemo.displayRow();
//        instance of Jdbc Batch Processing Demo class created
        JdbcBatchProcessingDemo batchProcessing= new JdbcBatchProcessingDemo();
        batchProcessing.batchProcessingDemo();
//        instance of Jdbc transaction demo created
        JdbcTransactionDemo transaction= new JdbcTransactionDemo();
        transaction.jdbcTransaction();
    }
}
