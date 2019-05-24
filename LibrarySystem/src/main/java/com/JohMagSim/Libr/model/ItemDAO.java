package com.JohMagSim.Libr.model;

import com.JohMagSim.Libr.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class ItemDAO {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //find item by ID
    public static Item findItembyId(int id)
    {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM item WHERE id = ? ;";
        ResultSet rs;
        Item result = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                LOGGER.info("No item found");
            } else {
                String type = rs.getString("itemType");
                if (type.equals("DVD")) {
                    // Create DVDitem from the result
                    DVDItem dvdItem = new DVDItem();
                    dvdItem.setId(rs.getInt("id"));
                    dvdItem.setISBNEAN(rs.getString("ISBN_EAN"));
                    dvdItem.setTitle(rs.getString("title"));
                    dvdItem.setType(rs.getString("itemType"));
                    dvdItem.setEdition(rs.getInt("edition"));
                    dvdItem.setYear(rs.getInt("year"));
                    dvdItem.setAgeRestriction(rs.getInt("age_restriction"));
                    dvdItem.setProdCountry(rs.getString("prod_country"));
                    dvdItem.setCategory(rs.getString("category"));
                    dvdItem.setLocation(rs.getString("location"));

                    String actorsFromDB = rs.getString("actors"); //actors as String
                    String[] split = actorsFromDB.split(","); //common array created by split
                    dvdItem.setActors(Arrays.asList(split)); //Change from array to list

                    dvdItem.setLoantime(rs.getInt("maximumLoanTime"));

                    result = dvdItem;
                }

                if(type.equals("Course book") || type.equals("Journal") || type.equals("Reference book") || type.equals("Regular book"))
                {
                    // Create Paperitem from the result.
                    PaperItem paperItem = new PaperItem();
                    paperItem.setId(rs.getInt("id"));
                    paperItem.setISBNEAN(rs.getString("ISBN_EAN"));
                    paperItem.setTitle(rs.getString("title"));
                    paperItem.setType(rs.getString("itemType"));
                    paperItem.setEdition(rs.getInt("edition"));
                    paperItem.setYear(rs.getInt("year"));
                    paperItem.setCategory(rs.getString("category"));
                    paperItem.setLocation(rs.getString("location"));

                    String authorsFromDB = rs.getString("authors"); //authors as String
                    String[] split = authorsFromDB.split(","); //common array created by split
                    paperItem.setAuthors(Arrays.asList(split)); //Change from array to list

                    paperItem.setLoantime(rs.getInt("maximumLoanTime"));
                    result = paperItem;

                }
            }

        } catch (SQLException e) {
            LOGGER.severe("findItemById " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }

    //find item by ID
    public static Item findItembyISBN(String ISBN)
    {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM item WHERE ISBN_EAN = ? ;";
        ResultSet rs;
        Item result = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ISBN);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                LOGGER.info("No item found");
            } else {
                String type = rs.getString("itemType");
                if (type.equals("DVD")) {
                    // Create DVDitem from the result
                    DVDItem dvdItem = new DVDItem();
                    dvdItem.setId(rs.getInt("id"));
                    dvdItem.setISBNEAN(rs.getString("ISBN_EAN"));
                    dvdItem.setTitle(rs.getString("title"));
                    dvdItem.setType(rs.getString("itemType"));
                    dvdItem.setEdition(rs.getInt("edition"));
                    dvdItem.setYear(rs.getInt("year"));
                    dvdItem.setAgeRestriction(rs.getInt("age_restriction"));
                    dvdItem.setProdCountry(rs.getString("prod_country"));
                    dvdItem.setCategory(rs.getString("category"));
                    dvdItem.setLocation(rs.getString("location"));

                    String actorsFromDB = rs.getString("actors"); //actors as String
                    String[] split = actorsFromDB.split(","); //common array created by split
                    dvdItem.setActors(Arrays.asList(split)); //Change from array to list

                    dvdItem.setLoantime(rs.getInt("maximumLoanTime"));

                    result = dvdItem;
                }

                if(type.equals("Course book") || type.equals("Journal") || type.equals("Reference book") || type.equals("Regular book"))
                {
                    // Create Paperitem from the result.
                    PaperItem paperItem = new PaperItem();
                    paperItem.setId(rs.getInt("id"));
                    paperItem.setISBNEAN(rs.getString("ISBN_EAN"));
                    paperItem.setTitle(rs.getString("title"));
                    paperItem.setType(rs.getString("itemType"));
                    paperItem.setEdition(rs.getInt("edition"));
                    paperItem.setYear(rs.getInt("year"));
                    paperItem.setCategory(rs.getString("category"));
                    paperItem.setLocation(rs.getString("location"));

                    String authorsFromDB = rs.getString("authors"); //authors as String
                    String[] split = authorsFromDB.split(","); //common array created by split
                    paperItem.setAuthors(Arrays.asList(split)); //Change from array to list

                    paperItem.setLoantime(rs.getInt("maximumLoanTime"));
                    result = paperItem;

                }
            }

        } catch (SQLException e) {
            LOGGER.severe("findItemByISBN " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }


    //Delete item by ID
    public static void deleteItemById(int id) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM item WHERE id = ? ;";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) { //SQL excetions fångas här
            LOGGER.severe("deleteItemById: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

    public static ArrayList<Item> findItemsFromTitleAuthorsActorItemtypeCategory
            (String search)
    {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM item WHERE title LIKE ? OR actors LIKE ? OR authors LIKE ?" +
                "OR itemType LIKE ? " +
                "OR category LIKE ? ";

        ResultSet rs = null;
        ArrayList<Item> result = new ArrayList<Item>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + search + "%");
            pstmt.setString(2, "%" + search + "%");
            pstmt.setString(3, "%" + search + "%");
            pstmt.setString(4, "%" + search + "%");
            pstmt.setString(5, "%" + search + "%");

            rs = pstmt.executeQuery();

            if (!rs.next()) { //om inget resultat
                new Exception("No item found");
            } else {
                do {
                    String type = rs.getString("itemType");
                    if (type.equals("DVD")) {
                        // Create DVDitem from the result
                        DVDItem dvdItem = new DVDItem();
                        dvdItem.setId(rs.getInt("id"));
                        dvdItem.setISBNEAN(rs.getString("ISBN_EAN"));
                        dvdItem.setTitle(rs.getString("title"));
                        dvdItem.setType(rs.getString("itemType"));
                        dvdItem.setEdition(rs.getInt("edition"));
                        dvdItem.setYear(rs.getInt("year"));
                        dvdItem.setAgeRestriction(rs.getInt("age_restriction"));
                        dvdItem.setProdCountry(rs.getString("prod_country"));
                        dvdItem.setCategory(rs.getString("category"));
                        dvdItem.setLocation(rs.getString("location"));

                        String actorsFromDB = rs.getString("actors"); //actors as String
                        String[] split = actorsFromDB.split(","); //common array created by split
                        dvdItem.setActors(Arrays.asList(split)); //Change from array to list

                        dvdItem.setLoantime(rs.getInt("maximumLoanTime"));

                        result.add(dvdItem);
                    }

                    if(type.equals("Course book") || type.equals("Journal") || type.equals("Reference book") || type.equals("Regular book"))
                    {
                        // Create Paperitem from the result.
                        PaperItem paperItem = new PaperItem();
                        paperItem.setId(rs.getInt("id"));
                        paperItem.setISBNEAN(rs.getString("ISBN_EAN"));
                        paperItem.setTitle(rs.getString("title"));
                        paperItem.setType(rs.getString("itemType"));
                        paperItem.setEdition(rs.getInt("edition"));
                        paperItem.setYear(rs.getInt("year"));
                        paperItem.setCategory(rs.getString("category"));
                        paperItem.setLocation(rs.getString("location"));

                        String authorsFromDB = rs.getString("authors"); //authors as String
                        String[] split = authorsFromDB.split(","); //common array created by split
                        paperItem.setAuthors(Arrays.asList(split)); //Change from array to list

                        paperItem.setLoantime(rs.getInt("maximumLoanTime"));
                        result.add(paperItem);

                    }

                } while (rs.next());
            }

        } catch (SQLException e) {
            LOGGER.severe("findItems " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }
}
