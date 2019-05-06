package com.JohMagSim.Libr.model;

import com.JohMagSim.Libr.utils.*;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class UserDAO {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    /**
     * findUserFromName takes in firstname and lastname parameterers and returns an arrayList of
     * users with names LIKE that. Remember LIKE require wildcard chars... :P
     * @param firstName string
     * @param lastName string
     * @return arrayList of Users containing fname,lname, email and id.
     */
    public static ArrayList<User> findUsersFromName(String firstName, String lastName){
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM users WHERE fName LIKE ? AND lName LIKE ?;";
        ResultSet rs = null;
        ArrayList<User> result = new ArrayList<User>();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            rs = pstmt.executeQuery();

                while(rs.next()){
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setFirstName(rs.getString("fName"));
                    user.setLastName(rs.getString("lName"));
                    user.setEmail(rs.getString("email"));
                    result.add(user);
                }

        } catch (SQLException e){
            LOGGER.severe("findUsersFromName " +e.getMessage());
        }
        return result;
    }

    /**
     * findUserFromId, takes user id and returns the user if exists.
     * @param id
     * @return
     */
    public static User findUserFromId(int id){
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM users WHERE id = ? ;";
        ResultSet rs = null;
        User result = null;
        // TODO: 05-05-2019 Should probably check what happens if user does not exist in db.
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            // Create user from the result.
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("fName"));
            user.setLastName(rs.getString("lName"));
            user.setEmail(rs.getString("email"));
            result = user;

        } catch (SQLException e){
            LOGGER.severe("findUserFromId " +e.getMessage());
        }
        return result;
    }

    /**
     * saveUser takes a user object, with all fields filled(!) and persists it.
     * Returns nothing but logs error.
     * @param user
     */
    public static void saveUser(User user){
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO users(fName,lName,email, passwordHash, passwordResetToken," +
                " userTypeID) VALUES(?,?,?,?,?,?) ;";

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
        }
    }
}
