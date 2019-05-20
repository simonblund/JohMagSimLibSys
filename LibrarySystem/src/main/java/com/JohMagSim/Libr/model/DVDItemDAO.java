package com.JohMagSim.Libr.model;

import com.JohMagSim.Libr.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class DVDItemDAO {
    //Delete DVD
    //Update DVD
    //findDVDbyActor
    //findDVDbytitle
    //findDVDbyisbnEAN
    //findORsökning OR-sökning på ej ISBN och ID

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void createDVDItem(DVDItem dvdItem) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO item(ISBN_EAN, title, itemType, edition, year, staff_id, age_restriction, prod_country, category, maximumLoanTime, actors) VALUES (?,?,?,?,?,?,?,?,?,?, ?);";
        //
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
            pstmt.setInt(10, dvdItem.getLoantime());
            pstmt.setString(11, allActors);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            LOGGER.severe("saveItem " + e.getMessage());

        } finally {
            DBConnection.closeConnection(conn);
        }
    }

    //findDVDbyID
    //Not woking ok. Must be fixed
    public static DVDItem findDVDbyId(int id) {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM item WHERE id = ? ;";
        ResultSet rs = null;
        DVDItem result = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

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

            // dvdItem.setActors(Collections.singletonList(rs.getString("actors")));

            dvdItem.setLoantime(rs.getInt("maximumLoanTime"));
            result = dvdItem;

        } catch (SQLException e) {
            LOGGER.severe("findDVDById " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }


}


