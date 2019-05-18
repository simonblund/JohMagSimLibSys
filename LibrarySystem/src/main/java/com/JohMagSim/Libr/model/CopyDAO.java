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
}
//to be done
//Update Copy, setState, setBarcode
//Remove Copy
//findCopiesByItemId, findCopyByBarcode, findCopiesByState