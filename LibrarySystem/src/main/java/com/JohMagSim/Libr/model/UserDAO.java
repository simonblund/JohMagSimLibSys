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
    public static ArrayList<User> findUsersFromName(String firstName, String lastName)throws Exception{
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM users WHERE fName LIKE ? AND lName LIKE ?;";
        ResultSet rs = null;
        ArrayList<User> result = new ArrayList<User>();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            rs = pstmt.executeQuery();

            //start new code
            if (!rs.next() ) {
                new Exception("No user found");
            } else {
                do {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setFirstName(rs.getString("fName"));
                    user.setLastName(rs.getString("lName"));
                    user.setEmail(rs.getString("email"));
                    user.setBooksAtATime(rs.getInt("BooksAtATime"));
                    user.setUserTypeID(rs.getInt("userTypeID"));
                    result.add(user);
                } while (rs.next());
            }
            // end new code

        } catch (SQLException e){
            LOGGER.severe("findUsersFromName " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }

    /**
     * findUserFromId, takes user id and returns the user if exists.
     * @param id
     * @return
     */
    public static User findUserFromId(int id) throws Exception{
                Connection conn = DBConnection.getConnection();
                String sql = "SELECT * FROM users WHERE id = ? ;";
                ResultSet rs = null;
                User result = null;
                try{
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, id);
                    rs = pstmt.executeQuery();
                    //start new code
                    if (!rs.next() ) {
                        new Exception("No user found");
                    } else {
                        User user = new User();
                        do {
                            user.setId(rs.getInt("id"));
                            user.setFirstName(rs.getString("fName"));
                            user.setLastName(rs.getString("lName"));
                            user.setEmail(rs.getString("email"));
                            user.setBooksAtATime(rs.getInt("BooksAtATime"));
                            user.setUserTypeID(rs.getInt("userTypeID"));
                            user.setPasswordHash(rs.getString("passwordHash"));
                        } while (rs.next());
                        result = user; // Since only one result is waited, this should work.
                    }
           // end new code

        } catch (SQLException e){
            LOGGER.severe("findUserFromId " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }

    /**
     * findUser from email
     * Uses email to frind a single unique user from the db.
     * @param email
     * @return
     */
    public static User findUserFromEmail(String email) throws Exception{
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM users WHERE email = ? ;";
        ResultSet rs = null;
        User result = null;
        // TODO: 05-05-2019 Should probably check what happens if user does not exist in db.
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if (!rs.next() ) {
                new Exception("No user found");
            } else {
                User user = new User();
                do {
                    user.setId(rs.getInt("id"));
                    user.setFirstName(rs.getString("fName"));
                    user.setLastName(rs.getString("lName"));
                    user.setEmail(rs.getString("email"));
                    user.setBooksAtATime(rs.getInt("BooksAtATime"));
                    user.setUserTypeID(rs.getInt("userTypeID"));
                    user.setPasswordHash(rs.getString("passwordHash"));
                } while (rs.next());
                result = user; // Since only one result is waited, this should work.
            }

            // Create user from the result.



        } catch (SQLException e){
            LOGGER.severe("findUserFromId " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
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
                " userTypeID, booksAtATime) VALUES(?,?,?,?,?,?,?) ;";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPasswordHash());
            pstmt.setString(5, user.getPasswordResetToken());
            pstmt.setInt(6, user.getUserTypeID());
            pstmt.setInt(7, user.getBooksAtATime());

            pstmt.executeUpdate();

        } catch (SQLException e){
            LOGGER.severe("saveUser " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

    /**
     * deleteUserFromId
     * @param id int for user id
     */

    public static void deleteUserFromId(int id){
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM users WHERE id = ? ;";

        // TODO: 05-05-2019 Should probably check what happens if user does not exist in db.
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e){
            LOGGER.severe("findUserFromId " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

    /**
     * Update the user, has to have a complete user object, this will not update the security parameters.
     * @param user User-object to be changed, must exist in DB.
     */
    public static void updateUser(User user){
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE users SET" +
                " fName = ?," +
                " lName = ?," +
                " email = ?," +
                " userTypeID = ?," +
                " booksAtATime = ?"+
                " WHERE id = ?;";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setInt(4, user.getUserTypeID());
            pstmt.setInt(5, user.getBooksAtATime());
            pstmt.setInt(6, user.getId());

            pstmt.executeUpdate();

        } catch (SQLException e){
            LOGGER.severe("updateUser " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

    /**
     * updateUserPassword takes a User object with a passwordHash, and updates it in the DB
     * @param user User Object
     */
    public static void updateUserPassword(User user){
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE users SET" +
                " passwordHash = ?" +
                " WHERE id = ?;";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setString(1, user.getPasswordHash());
            pstmt.setInt(2, user.getId());
            pstmt.executeUpdate();

        } catch (SQLException e){
            LOGGER.severe("updateUserPassword " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

    /**
     * updateUserPasswordResetToken takes a user object and updates the PasswordResetToken in the DB according
     * to the one set in the user object.
     * @param user User object with a new pswRT variable.
     */
    public static void updateUserPasswordResetToken(User user){
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE users SET" +
                " passwordResetToken = ?" +
                " WHERE id = ?;";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setString(1, user.getPasswordResetToken());
            pstmt.setInt(2, user.getId());
            pstmt.executeUpdate();

        } catch (SQLException e){
            LOGGER.severe("updateUserPasswordResetToken " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }
}
