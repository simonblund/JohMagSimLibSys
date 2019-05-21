package com.JohMagSim.Libr.model;

import com.JohMagSim.Libr.utils.*;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class StaffDAO {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    /**
     * Search for staff with firstname and lastname, returns staff with all parameters from
     * both tables. Only returns staff by using inner join in sql.
     * @param firstName String First name
     * @param lastName String last name
     * @return Arraylist with staffs.
     */
    public static ArrayList<Staff> findStaffFromName(String firstName, String lastName){
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM users INNER JOIN staff ON users.staffID = staff.id WHERE fName LIKE ? " +
                "AND lName LIKE ?;";
        ResultSet rs = null;
        ArrayList<Staff> result = new ArrayList<Staff>();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            rs = pstmt.executeQuery();

            while(rs.next()){
                Staff user = new Staff();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("fName"));
                user.setLastName(rs.getString("lName"));
                user.setEmail(rs.getString("email"));
                user.setStaffId(rs.getInt("staffID"));
                user.setManagerint(rs.getInt("manager"));
                result.add(user);
            }

        } catch (SQLException e){
            LOGGER.severe("findStaffsFromName " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }

    /**
     * findUserFromId, takes user id and returns the staff if exists.
     * @param id
     * @return
     */
    public static Staff findStaffFromId(int id){
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM users INNER JOIN staff ON users.staffID = staff.id WHERE users.id = ?;";
        ResultSet rs = null;
        Staff result = null;
        // TODO: 05-05-2019 Should probably check what happens if user does not exist in db.
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            // Create user from the result.
            Staff user = new Staff();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("fName"));
            user.setLastName(rs.getString("lName"));
            user.setEmail(rs.getString("email"));
            user.setStaffId(rs.getInt("staffID"));
            user.setManagerint(rs.getInt("manager"));
            result = user;

        } catch (SQLException e){
            LOGGER.severe("findStaffFromId " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }

    public static Staff findStaffFromEmail(String email){
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM users INNER JOIN staff ON users.staffID = staff.id WHERE users.email = ?;";
        ResultSet rs = null;
        Staff result = null;
        // TODO: 05-05-2019 Should probably check what happens if user does not exist in db.
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            // Create user from the result.
            Staff user = new Staff();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("fName"));
            user.setLastName(rs.getString("lName"));
            user.setEmail(rs.getString("email"));
            user.setStaffId(rs.getInt("staffID"));
            user.setManagerint(rs.getInt("manager"));
            result = user;

        } catch (SQLException e){
            LOGGER.severe("findStaffFromEmail " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }

    /**
     * saveUser takes a staff object, with all fields filled(!) and persists it.
     * Returns nothing but logs error.
     *
     * NOTE: Aparently when doing multiple inserts you have to separate the prepared statements. Check the solution.
     * @param user
     */
    public static void saveStaff(Staff user){
        Connection conn = DBConnection.getConnection();

        String sql_staff = "INSERT INTO staff (manager) VALUES(?); ";

        String sql = "INSERT INTO users(fName,lName,email, passwordHash, passwordResetToken," +
                " userTypeID, staffID) VALUES(?,?,?,?,?,?,(SELECT last_insert_rowid() FROM staff));";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            PreparedStatement pstmt_staff = conn.prepareStatement(sql_staff);

            pstmt_staff.setInt(1, user.isManagerint());
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPasswordHash());
            pstmt.setString(5, user.getPasswordResetToken());
            pstmt.setInt(6, user.getUserTypeID());


            pstmt_staff.executeUpdate();
            pstmt.executeUpdate();

        } catch (SQLException e){
            LOGGER.severe("saveStaff " +e.getMessage());
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
                " userTypeID = ?" +
                " WHERE id = ?;";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setInt(4, user.getUserTypeID());
            pstmt.setInt(5, user.getId());

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
