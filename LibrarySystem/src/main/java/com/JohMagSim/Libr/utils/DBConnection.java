package com.JohMagSim.Libr.utils;

import java.sql.*;

/**
 * This is just an example class to use for creating connections in the DAO-classes.
 */

public class DBConnection {
    private static Connection connection = null;

    private static void createConnection(){
        try {
           connection = DriverManager.getConnection(DBInitiation.url);
            System.out.println("DB created");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection(){
        if(connection == null){
            createConnection();
            return connection;
        }
        else {
            return connection;
        }
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
