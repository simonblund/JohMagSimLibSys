package com.JohMagSim.Libr.utils;

import java.sql.*;

public class DBInitiation {
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

    private static void createUsersTable(){
        Connection conn = null;
        Statement stmt = null;
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	fName text NOT NULL,\n"
                + "	lName text NOT NULL,\n"
                + "	email text NOT NULL UNIQUE,\n"
                + "	passwordHash text NOT NULL,\n"
                + "	passwordResetToken text NOT NULL,\n"
                + "	userTypeID integer DEFAULT 1,\n"
                + "	staffID integer\n"
                + ");";
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:library.db");
            System.out.println("DB connected");
            stmt = conn.createStatement();
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void createTables() {
        createUsersTable();
    }

}
