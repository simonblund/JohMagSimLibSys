package com.JohMagSim.Libr.model;

import com.JohMagSim.Libr.utils.*;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class UserDAO {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    /**
     * findUserFromName takes in firstname and lastname parameterers and returns an arrayList of
     * users with names LIKE that.
     * @param firstName
     * @param lastName
     * @return arrayList of Users containing fname,lname, email and id.
     */
    public static ArrayList findUserFromName(String firstName, String lastName){
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM users WHERE fName LIKE ? AND lName LIKE ?;";
        ResultSet rs = null;
        ArrayList result = new ArrayList();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            rs = pstmt.executeQuery();

            if(rs!=null){
                while(rs.next()){
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setFirstName(rs.getString("fName"));
                    user.setLastName(rs.getString("lName"));
                    user.setEmail(rs.getString("email"));
                    result.add(user);
                }
            }
        } catch (SQLException e){
            LOGGER.severe("findUsernameFromName " +e.getMessage());
        }
        return result;
    }
}
