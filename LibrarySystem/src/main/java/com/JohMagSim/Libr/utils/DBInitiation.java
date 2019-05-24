package com.JohMagSim.Libr.utils;
/*
 * This class is used to create tables in the library sqlite database.
 * @Author SimonBlund
 */


import java.sql.*;
import java.util.logging.*;

public class DBInitiation {
    public static final String url = "jdbc:sqlite:library.db";
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


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
            LOGGER.finer(" DBInitiation.class: DB connected for creation of "+table);
            stmt = conn.createStatement();
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            LOGGER.severe(" DBInitiation.class: In creation of table "+table+" this occurred "+e.getMessage());
        } finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e){
                LOGGER.severe(" DBInitiation.class: In closing of connection creating  of table "+table+" this occurred "+e.getMessage());
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
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	fName text NOT NULL,\n"
                + "	lName text NOT NULL,\n"
                + "	email text NOT NULL UNIQUE,\n"
                + "	passwordHash text NOT NULL,\n"
                + "	passwordResetToken text NOT NULL,\n"
                + "	userTypeID integer NOT NULL,\n"
                + "	booksAtATime integer,\n"
                + "	staffID integer,\n"
                + "	FOREIGN KEY (staffID) REFERENCES staff(id) ON DELETE CASCADE \n"
                + ");", "users");

        // Staff table
        createTable("CREATE TABLE IF NOT EXISTS staff (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	manager integer DEFAULT 0\n"
                + ");", "staff");

        // Item table
        createTable("CREATE TABLE IF NOT EXISTS item (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " ISBN_EAN text NOT NULL UNIQUE, \n"
                + "	title text NOT NULL,\n"
                + "	itemType text NOT NULL,\n"
                + "	edition integer NOT NULL DEFAULT 1,\n"
                + "	year integer,\n"
                + "	staff_id integer,\n"
                + "	age_restriction integer,\n"
                + "	prod_country text,\n"
                + "	category text,\n"
                + "	location text,\n"
                + "	actors text,\n"
                + "	authors text,\n"
                + "	maximumLoanTime integer NOT NULL DEFAULT 14,\n"
                + "	FOREIGN KEY (staff_id) REFERENCES staff(id) ON DELETE SET NULL\n"
                + ");", "Item");

        // Copy table
        createTable("CREATE TABLE IF NOT EXISTS copy (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	item_id integer,\n"
                + "	barcode text NOT NULL UNIQUE,\n"
                + "	state integer DEFAULT 0,\n"
                + "	FOREIGN KEY (item_id) REFERENCES item(id) ON DELETE CASCADE \n"
                + ");", "copy");

        // Loan table
        createTable("CREATE TABLE IF NOT EXISTS loan (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	copy_id integer,\n"
                + "	user_id integer,\n"
                + "	timeOfCheckout text NOT NULL,\n"
                + "	timeOfExpectedReturn text,\n"
                + "	timeOfReturn text,\n"
                + "	FOREIGN KEY (copy_id) REFERENCES copy(id) ON DELETE CASCADE, \n"
                + "	FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE \n"
                + ");", "loan");


    }

}
