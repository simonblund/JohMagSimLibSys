package com.JohMagSim.Libr.model;

import com.JohMagSim.Libr.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class DVDItemDAO {}
/*
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public int createDVDItem(DVDItem dvdItem){
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO item(ISBN_EAN, title, edition, year, staff_id, itemCategory_id " +
                    //lägg till allt för DVD på item i DB
                    ") VALUES (?,?,?,?,?,?);";
            List<String> actors = dvdItem.getActors();
            StringBuilder sb = new StringBuilder(); //bygger en sträng
            for (String actor : actors) {
                sb.append(actor); //första actor, andra actor
                sb.append(", "); //separator
            }
            String allActors= sb.toString(); //alla mina actors i en sträng

        try{
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // Set the parameters
                pstmt.setString(1, user.getFirstName());
                pstmt.setString(2, user.getLastName());
                pstmt.setString(3, user.getEmail());
                pstmt.setString(4, user.getPasswordHash());
                pstmt.setString(5, user.getPasswordResetToken());
                pstmt.setInt(6, user.getUsertype().getId());

                pstmt.executeUpdate();

            } catch (SQLException e){
                LOGGER.severe("saveUser " +e.getMessage());
            } finally {
                DBConnection.closeConnection(conn);
            }

            //select för att ta fram itemId
            return itemId;
        }



    }

    public static void deleteDVDById(int id){}
}
*/
