package com.JohMagSim.Libr.model;

import com.JohMagSim.Libr.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class CopyDAO {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void createCopy(Copy copy) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO copy(item_id,barcode,state) VALUES(?,?,?);";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setInt(1, copy.getItemID());
            pstmt.setInt(2, copy.getBarCode());
            pstmt.setInt(3, copy.getState());
            pstmt.executeUpdate();

        } catch (SQLException e) {

            LOGGER.severe("saveCopy " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

    public static Copy findCopybyBarcode(int barcode) {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM copy WHERE barcode = ? ;";
        ResultSet rs = null;
        Copy result = null;
        // TODO: 05-05-2019 Should probably check what happens if copy does not exist in db
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, barcode);
            rs = pstmt.executeQuery();

            // Create copy from the result.
            Copy copy = new Copy();
            copy.setId(rs.getInt("id"));
            copy.setBarCode(rs.getInt("barcode"));
            copy.setState(rs.getInt("state"));
            result = copy;

        } catch (SQLException e) {
            LOGGER.severe("findCopyFrombarcode " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }

    public static ArrayList<Copy> findCopiesFromitemId(int id) {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM item, copy WHERE item.id=copy.item_id AND item.id=?;";

        ResultSet rs = null;
        ArrayList<Copy> result = new ArrayList<Copy>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(id));
            rs = pstmt.executeQuery();

            if (!rs.next()) { //om inget resultat
                new Exception("No copyItem found");
            } else {
                do {
                    Copy copy = new Copy();
                    copy.setItemID(rs.getInt("item_id"));
                    copy.setId(rs.getInt("id"));
                    copy.setBarCode(rs.getInt("barcode"));
                    copy.setState(rs.getInt("state"));

                    result.add(copy);
                } while (rs.next());
            }

        } catch (SQLException e) {
            LOGGER.severe("findCopiesFromItemId: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }

    public static void deleteCopyById(int id) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM copy WHERE id = ? ;";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) { //SQL excetions fångas här
            LOGGER.severe("deleteCopyById: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

    public static int uppdateCopy(Copy copy, int id) {
        int updates = -1; //count for nr of updates
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE copy SET " +
                "barcode=?," +
                "item_id=?," +
                "state=?" +
                "WHERE id=?;";

        try {

            PreparedStatement pstmt = conn.prepareStatement(sql);
            // Set the parameters

            pstmt.setInt(1, copy.getBarCode());
            pstmt.setInt(2, copy.getItemID());
            pstmt.setInt(3, copy.getState());
            pstmt.setInt(4, id); //id for the copy that should be updated
            pstmt.executeUpdate();

            updates = pstmt.getUpdateCount();

        } catch (SQLException e) {
            LOGGER.severe("UppdateCopy: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return updates;

    }
}