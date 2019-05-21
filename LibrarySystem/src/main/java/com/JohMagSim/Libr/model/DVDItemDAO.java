package com.JohMagSim.Libr.model;

import com.JohMagSim.Libr.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class DVDItemDAO {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static int createDVDItem(DVDItem dvdItem) {
        int key = -1; //generated key
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO item(ISBN_EAN, title, itemType, edition, year, staff_id, age_restriction, prod_country, category, location, maximumLoanTime, actors) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        List<String> actors = dvdItem.getActors(); //gör om listan till sträng
        StringBuilder sb = new StringBuilder(); //bygger en sträng
        for (String actor : actors) {
            sb.append(actor); //första actor, andra actor
            sb.append(", "); //separator
        }
        String allActors = sb.toString(); //alla mina actors i en sträng

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // Set the parameters
            pstmt.setString(1, dvdItem.getISBNEAN());
            pstmt.setString(2, dvdItem.getTitle());
            pstmt.setString(3, dvdItem.getType());
            pstmt.setInt(4, dvdItem.getEdition());
            pstmt.setInt(5, dvdItem.getYear());
            pstmt.setInt(6, dvdItem.getStaffId());
            pstmt.setInt(7, dvdItem.getAgeRestriction());
            pstmt.setString(8, dvdItem.getProdCountry());
            pstmt.setString(9, dvdItem.getCategory());
            pstmt.setString(10, dvdItem.getLocation());
            pstmt.setInt(11, dvdItem.getLoantime());
            pstmt.setString(12, allActors);
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            key = generatedKeys.getInt(1);


        } catch (SQLException e) {
            LOGGER.severe("saveDVDItem: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return key;
    }

    public static DVDItem findDVDbyId(int id)
    //throws Exception
    {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM item WHERE id = ? ;";
        ResultSet rs;
        DVDItem result = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                new Exception("No DVD found");
                System.out.println("No DVD found");
            } else {

                // Create DVDitem from the result.
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

        } catch (SQLException e) {
            LOGGER.severe("findDVDById " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }

    public static void deleteDVDById(int id) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM item WHERE id = ? ;";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            LOGGER.severe("deleteDVDFromId: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

    //UpdateDVD, To do - if int id dont exist in db
    public static int uppdateDVDItem(DVDItem dvdItem, int id) {
        int updates = -1; //count for nr of updates
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE item SET " +
                "ISBN_EAN=?," +
                "title=?," +
                "itemType=?," +
                "edition=?," +
                "year=?," +
                "staff_id=?," +
                "age_restriction=?," +
                "prod_country=?," +
                "category=?," +
                "location=?," +
                "maximumLoanTime=?," +
                "actors=? " +
                "WHERE id= ?;";
        List<String> actors = dvdItem.getActors(); //gör om listan till sträng
        StringBuilder sb = new StringBuilder(); //bygger en sträng
        for (String actor : actors) {
            sb.append(actor); //första actor, andra actor
            sb.append(", "); //separator
        }
        String allActors = sb.toString(); //alla mina actors i en sträng

        try {

            PreparedStatement pstmt = conn.prepareStatement(sql);
            // Set the parameters

            pstmt.setString(1, dvdItem.getISBNEAN());
            pstmt.setString(2, dvdItem.getTitle());
            pstmt.setString(3, dvdItem.getType());
            pstmt.setInt(4, dvdItem.getEdition());
            pstmt.setInt(5, dvdItem.getYear());
            pstmt.setInt(6, dvdItem.getStaffId());
            pstmt.setInt(7, dvdItem.getAgeRestriction());
            pstmt.setString(8, dvdItem.getProdCountry());
            pstmt.setString(9, dvdItem.getCategory());
            pstmt.setString(10, dvdItem.getLocation());
            pstmt.setInt(11, dvdItem.getLoantime());
            pstmt.setString(12, allActors);
            pstmt.setInt(13, id); //id for the item that should be updated
            pstmt.executeUpdate();

            updates = pstmt.getUpdateCount();

        } catch (SQLException e) {
            LOGGER.severe("UppdateDVDItem: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return updates;

    }

    //Find item from actor
    public static ArrayList<DVDItem> findDVDFromActor(String actor)
    //throws Exception
    {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM item WHERE actors LIKE ? AND itemType=?;";
        ResultSet rs = null;
        ArrayList<DVDItem> result = new ArrayList<DVDItem>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + actor + "%");
            pstmt.setString(2, "DVD");
            rs = pstmt.executeQuery();

            if (!rs.next()) { //om inget resultat
                new Exception("No actor found");
            } else {
                do {
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
                } while (rs.next());
            }

        } catch (SQLException e) {
            LOGGER.severe("findDVDItemFromActor " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }


    //Find item from actor
    public static ArrayList<DVDItem> findDVDFromTitle(String title)
    //throws Exception
    {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM item WHERE title LIKE ? AND itemType=?;";
        ResultSet rs = null;
        ArrayList<DVDItem> result = new ArrayList<DVDItem>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + title + "%");
            pstmt.setString(2, "DVD");
            rs = pstmt.executeQuery();

            if (!rs.next()) { //om inget resultat
                new Exception("No DVD found");
            } else {
                do {
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
                } while (rs.next());
            }

        } catch (SQLException e) {
            LOGGER.severe("findDVDItemFromTitle " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }


    //Find item from actor
    public static ArrayList<DVDItem> findDVDFromTitleActorCountyAgeCategory
    (String title, String actor, String county, int age, String category)
    //throws Exception
    {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM item WHERE title LIKE ? AND actors LIKE ? " +
                "AND prod_country LIKE ? " +
                "AND category LIKE ? AND age_restriction=? AND itemType=?;";

        ResultSet rs = null;
        ArrayList<DVDItem> result = new ArrayList<DVDItem>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + title + "%");
            pstmt.setString(2, "%" + actor + "%");
            pstmt.setString(3, "%" + county + "%");
            pstmt.setString(4, "%" + category + "%");
            pstmt.setInt(5, age);
            pstmt.setString(6, "DVD");
            rs = pstmt.executeQuery();

            if (!rs.next()) { //om inget resultat
                new Exception("No DVD found");
            } else {
                do {
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
                } while (rs.next());
            }

        } catch (SQLException e) {
            LOGGER.severe("findDVDItemFromTitle " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }

}


