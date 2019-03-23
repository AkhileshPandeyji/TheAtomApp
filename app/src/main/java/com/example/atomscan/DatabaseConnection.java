package com.example.atomscan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    static private Connection connection;
    static private ResultSet result;
    static private PreparedStatement stmt;


    static public void connect(String url,String u_name,String pass){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,u_name,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    static public void doQuery(String query){
        try {
            stmt = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static public ResultSet response(){
        result = null;
        try {
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    static public void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
