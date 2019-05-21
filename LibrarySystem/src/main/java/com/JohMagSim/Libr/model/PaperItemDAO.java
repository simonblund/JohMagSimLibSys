package com.JohMagSim.Libr.model;

import com.JohMagSim.Libr.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class PaperItemDAO {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static int createPaperItem(PaperItem paperItem) {
        int key = -1; //generated key
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO item(ISBN_EAN, title, itemType, edition, year, staff_id, category, location, maximumLoanTime, authors) VALUES (?,?,?,?,?,?,?,?,?,?);";
        List<String> authors = paperItem.getAuthors(); //gör om listan till sträng
        StringBuilder sb = new StringBuilder(); //bygger en sträng
        for (String author : authors) {
            sb.append(author); //första author, andra author
            sb.append(", "); //separator
        }
        String allAuthors = sb.toString(); //alla mina authors i en sträng

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // Set the parameters
            pstmt.setString(1, paperItem.getISBNEAN());
            pstmt.setString(2, paperItem.getTitle());
            pstmt.setString(3, paperItem.getType());
            pstmt.setInt(4, paperItem.getEdition());
            pstmt.setInt(5, paperItem.getYear());
            pstmt.setInt(6, paperItem.getStaffId());
            pstmt.setString(7, paperItem.getCategory());
            pstmt.setString(8, paperItem.getLocation());
            pstmt.setInt(9, paperItem.getLoantime());
            pstmt.setString(10, allAuthors);
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            key = generatedKeys.getInt(1);


        } catch (SQLException e) {
            LOGGER.severe("savePaperItem: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return key;
    }

    public static PaperItem findpaperItembyId(int id) {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM item WHERE id = ? ;";
        ResultSet rs;
        PaperItem result = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

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

        } catch (SQLException e) {
            LOGGER.severe("findDVDById " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }

}
