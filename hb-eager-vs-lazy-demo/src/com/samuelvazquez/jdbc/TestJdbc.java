package com.samuelvazquez.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String dbName = "hb-01-one-to-one-uni";
        String jdbcUrl = "jdbc:mysql://localhost/"+dbName;
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);

            System.out.println("Connection successful!!!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
