package com.JohMagSim.Libr.model;

import com.JohMagSim.Libr.utils.*;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class LoanDAO {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //@TODO update findLoanFromUserID with Copy
    //@TODO add more methods
    //@TODO the find loan functions will probably need to filter out returned or old loans somehow.


    /**
     * findLoansFromUserID takes in UserId parameter and returns an arrayList of
     * loans connected to that user.
     * @param userID
     * @return arrayList of Loans containing date of checkout, returndate, and copy.
     */


    public static ArrayList findLoanFromUserID(int userID){
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM loan WHERE UserID = ?;";
        ResultSet rs = null;
        ArrayList result = new ArrayList();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            rs = pstmt.executeQuery();

            if(rs!=null){
                while(rs.next()){
                    Loan loan = new Loan();
                    loan.setDate(rs.getString("timeOfCheckout"));
                    loan.setReturnDate(rs.getString("timeOfReturn"));
                    //loan.setCopy;
                    result.add(loan);
                }
            }
        } catch (SQLException e){
            LOGGER.severe("findLoanFromUserID " + e.getMessage());
        }
        return result;
    }

}
