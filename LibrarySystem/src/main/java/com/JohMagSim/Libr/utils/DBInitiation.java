package com.JohMagSim.Libr.utils;
/**
 * This class is used to create tables in the library sqlite database.
 * @Author SimonBlund
 */


import java.sql.*;

public class DBInitiation {
    public static final String url = "jdbc:sqlite:library.db";


    /**
     * Is used to create the tables, takes in sql for the table creation and
     * table name for error logging.
     * @param sql String SQL to create the table.
     * @param table String tablename used for error logging.
     */
    private static void createTable(String sql, String table){
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("DB connected for creation of "+table);
            stmt = conn.createStatement();
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println("In creation of table "+table+" this occured "+e.getMessage());
        } finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e){
                System.out.println("In closing of connection creating  of table "+table+" this occured "+e.getMessage());
            }
        }
    }

    /**
     * This method runs the initialisation processes for the database.
     * If new tables are needed just add their create statements here.
     */
    public static void createTables() {

        // Users table
        createTable("CREATE TABLE IF NOT EXISTS users (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	fName text NOT NULL,\n"
                + "	lName text NOT NULL,\n"
                + "	email text NOT NULL UNIQUE,\n"
                + "	passwordHash text NOT NULL,\n"
                + "	passwordResetToken text NOT NULL,\n"
                + "	userTypeID integer DEFAULT 1,\n"
                + "	staffID integer,\n"
                + "	FOREIGN KEY (staffID) REFERENCES staff(id) ON DELETE CASCADE \n"
                + ");", "users");

        // UserType table
        createTable("CREATE TABLE IF NOT EXISTS usertype (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	description text NOT NULL,\n"
                + "	booksAtATime integer NOT NULL\n"
                + ");", "userType");

        // Staff table
        createTable("CREATE TABLE IF NOT EXISTS staff (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	manager integer DEFAULT 0,\n"
                + "	booksAtATime integer NOT NULL\n"
                + ");", "staff");

    }

}
