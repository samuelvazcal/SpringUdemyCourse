package com.samuelvazquez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        String dbName = "pokemon_kanto_team";
        String url = "jdbc:mysql://localhost/" + dbName;
        String user = "hbstudent";
        String password = "hbstudent";

        try {
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(url,user,password);

            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
