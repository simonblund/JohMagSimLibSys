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
                + "	manager integer DEFAULT 0\n"
                + ");", "staff");

        // Item table
        createTable("CREATE TABLE IF NOT EXISTS item (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " ISBN_EAN text NOT NULL, \n"
                + "	title text NOT NULL,\n"
                + "	edition integer NOT NULL DEFAULT 1,\n"
                + "	year integer,\n"
                + "	staff_id integer,\n"
                + "	itemCategory_id integer,\n"
                + "	FOREIGN KEY (staff_id) REFERENCES staff(id) ON DELETE SET NULL, \n"
                + "	FOREIGN KEY (publisher_id) REFERENCES publisher(id) ON DELETE SET NULL, \n"
                + "	FOREIGN KEY (itemCategory_id) REFERENCES itemCategory(id) ON DELETE SET NULL \n"
                + ");", "Item");

        // ItemCategory table
        createTable("CREATE TABLE IF NOT EXISTS itemCategory (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	maximumLoanTime integer NOT NULL DEFAULT 14\n"
                + ");", "ItemCategory");

        // AuthorArtist table
        createTable("CREATE TABLE IF NOT EXISTS authorArtist (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	fName text NOT NULL,\n"
                + "	lName text NOT NULL\n"
                + ");", "authorArtist");

        // AuthorItem table
        createTable("CREATE TABLE IF NOT EXISTS author_item (\n"
                + "	author_id integer NOT NULL,\n"
                + "	item_id integer NOT NULL,\n"
                + "	PRIMARY KEY (author_id, item_id), \n"
                + "	FOREIGN KEY (author_id) REFERENCES authorArtist(id) ON DELETE CASCADE, \n"
                + "	FOREIGN KEY (item_id) REFERENCES item(id) ON DELETE CASCADE \n"
                + ");", "author_item");

        // Copy table
        createTable("CREATE TABLE IF NOT EXISTS copy (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	item_id integer,\n"
                + "	barcode text NOT NULL,\n"
                + "	state integer DEFAULT 0,\n"
                + "	FOREIGN KEY (item_id) REFERENCES item(id) ON DELETE CASCADE \n"
                + ");", "copy");

        // Loan table
        createTable("CREATE TABLE IF NOT EXISTS loan (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	copy_id integer,\n"
                + "	user_id integer,\n"
                + "	timeOfCheckout text NOT NULL,\n"
                + "	timeOfExpectedReturn text,\n"
                + "	timeOfReturn text,\n"
                + "	FOREIGN KEY (copy_id) REFERENCES copy(id) ON DELETE CASCADE, \n"
                + "	FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE \n"
                + ");", "loan");

        // dvd table
        createTable("CREATE TABLE IF NOT EXISTS dvd (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	item_id integer,\n"
                + "	age_restriction integer,\n"
                + "	director text NOT NULL,\n"
                + "	prod_country text,\n"
                + "	FOREIGN KEY (item_id) REFERENCES item(id) ON DELETE CASCADE \n"
                + ");", "dvd");

    }

}
