package com.JohMagSim.Libr.utils;

import java.sql.*;

/**
 * This is just an example class to use for creating connections in the DAO-classes.
 */

public class DBConnection {
    private Connection connection = null;

    private void createConnection(){
        try {
           connection = DriverManager.getConnection("jdbc:sqlite:library.db");
            System.out.println("DB created");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private Connection getConnection(){
        if(connection == null){
            createConnection();
            return connection;
        }
        else {
            return connection;
        }
    }

    private void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
