package com.example.atomscan;

import android.os.StrictMode;

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
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,u_name,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    static public void doQuery(String query,String... params){
        try {
            stmt = connection.prepareStatement(query);
            int count = 1;
            while( count >= params.length) {
                stmt.setString(0, params[0]);
                count++;
            }
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
