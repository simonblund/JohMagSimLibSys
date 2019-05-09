package com.JohMagSim.Libr.model;

import com.JohMagSim.Libr.utils.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.*;

public class LoanDAO {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //@TODO update findLoanFromUserID with Copy
    //@TODO add more methods
    //@TODO the find loan functions will probably need to filter out returned or old loans somehow.
    //@TODO add methods for
    //  insert
    //  update
    //  delete


    /**
     * findLoansFromUserID takes in UserId parameter and returns an arrayList of
     * loans connected to that user.
     * @param userID
     * @return arrayList of Loans containing date of checkout, returndate, and copy.
     */


    public static ArrayList findActiveLoansFromUserID(int userID){
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM loan WHERE user_id = ? AND timeOfReturn IS NULL;";
        ResultSet rs = null;
        ArrayList result = new ArrayList();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            rs = pstmt.executeQuery();
            LocalDate checkOutDate;
            LocalDate returnDate;

            if(rs!=null){
                while(rs.next()){
                    Loan loan = new Loan();
                    checkOutDate = LocalDate.parse(rs.getString("timeOfCheckout"));
                    loan.setDate(checkOutDate);
                    returnDate = LocalDate.parse(rs.getString("timeOfReturn"));
                    loan.setReturnDate(returnDate);
                    //loan.setCopy;
                    result.add(loan);
                }
            }
        } catch (SQLException e){
            LOGGER.severe("findLoanFromUserID " + e.getMessage());
        }
        return result;
    }

    /**
     * insertLoan takes a loan object, with all fields filled(!) and persists it.
     * Returns nothing but logs error.
     * @param loan takes a full Loan object
     */

    public static void insertLoan(Loan loan){
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO loan(copy_id, user_id, timeOfCheckout, timeOfExpectedReturn" +
                ") VALUES(?,?,?,?) ;";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setInt(1, loan.getCopy().getItemID());
            pstmt.setInt(2, loan.getUser().getId());
            pstmt.setString(3, loan.getDate().toString());
            pstmt.setString(4, loan.getReturnDate().toString());

            pstmt.executeUpdate();

        } catch (SQLException e){
            LOGGER.severe("saveUser " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

}
