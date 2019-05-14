package com.JohMagSim.Libr.model;

import com.JohMagSim.Libr.utils.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.*;

public class LoanDAO {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //@TODO add methods for
    //  insert
    //  update
    //  delete

    /**
     * findAllActiveLoans returns an arrayList of all active loans
     *
     * @return arrayList of Loans containing date of checkout, returndate, copyID and userID.
     */


    public static ArrayList findAllActiveLoans(){
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM loan;";
        ResultSet rs = null;
        ArrayList result = new ArrayList();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            LocalDate checkOutDate;
            LocalDate returnDate;

            if(rs!=null){
                while(rs.next()){
                    //create new loan
                    Loan loan = new Loan();
                    //set Checkoutdate
                    checkOutDate = LocalDate.parse(rs.getString("timeOfCheckout"));
                    loan.setDate(checkOutDate);
                    //set expected returndate
                    returnDate = LocalDate.parse(rs.getString("timeOfExpectedReturn"));
                    loan.setExpectedReturnDate(returnDate);
                    //set copyId
                    loan.setCopyID(rs.getInt("copy_id"));
                    //set userId
                    loan.setCopyID(rs.getInt("user_id"));
                    result.add(loan);
                }
            }
        } catch (SQLException e){
            LOGGER.severe("findAllActiveLoans " + e.getMessage());
        }
        return result;
    }

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
                    //create new loan
                    Loan loan = new Loan();
                    //set Checkoutdate
                    checkOutDate = LocalDate.parse(rs.getString("timeOfCheckout"));
                    loan.setDate(checkOutDate);
                    //set expected returndate
                    returnDate = LocalDate.parse(rs.getString("timeOfReturn"));
                    loan.setExpectedReturnDate(returnDate);
                    //set copyId
                    loan.setCopyID(rs.getInt("copy_id"));
                    //set userId
                    loan.setCopyID(rs.getInt("user_id"));
                    result.add(loan);
                }
            }
        } catch (SQLException e){
            LOGGER.severe("findActiveLoansFromUserID " + e.getMessage());
        }
        return result;
    }

    /**
     * findOverdueLoans returns an arrayList of all active, but overdue, loans
     *
     * @return arrayList of Loans containing date of checkout, returndate, copyID and userID.
     */


    public static ArrayList findOverdueLoans(){
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM loan WHERE timeOfExpectedReturn < ?;";
        ResultSet rs = null;
        ArrayList result = new ArrayList();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            LocalDate todaysDate = LocalDate.now();
            pstmt.setString(1, todaysDate.toString());
            rs = pstmt.executeQuery();
            LocalDate checkOutDate;
            LocalDate returnDate;

            if(rs!=null){
                while(rs.next()){
                    //create new loan
                    Loan loan = new Loan();
                    //set Checkoutdate
                    checkOutDate = LocalDate.parse(rs.getString("timeOfCheckout"));
                    loan.setDate(checkOutDate);
                    //set expected returndate
                    returnDate = LocalDate.parse(rs.getString("timeOfExpectedReturn"));
                    loan.setExpectedReturnDate(returnDate);
                    //set copyId
                    loan.setCopyID(rs.getInt("copy_id"));
                    //set userId
                    loan.setCopyID(rs.getInt("user_id"));
                    result.add(loan);
                }
            }
        } catch (SQLException e){
            LOGGER.severe("findOverdueLoans " + e.getMessage());
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
            pstmt.setInt(1, loan.getCopyID());
            pstmt.setInt(2, loan.getUserID());
            pstmt.setString(3, loan.getDate().toString());
            pstmt.setString(4, loan.getExpectedReturnDate().toString());

            pstmt.executeUpdate();

        } catch (SQLException e){
            LOGGER.severe("insertLoan " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

    /**
     * updateReturnDateOnLoan takes a loan object, a new date and updates the timeOfExpectedReturn in database.
     * Returns nothing but logs error.
     * @param loan      takes a full Loan object
     * @param newDate   a new date to be set as expected returndate
     */

    public static void updateExpectedReturnDateOnLoan(Loan loan, String newDate){
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE loan SET" +
                " timeOfExpectedReturn = ?," +
                " WHERE id = ?;";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setString(1, newDate);
            pstmt.setInt(2, loan.getLoanID());

            pstmt.executeUpdate();

        } catch (SQLException e){
            LOGGER.severe("updateExpectedReturnDateOnLoan " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

    /**
     * updateReturnDateOnLoan takes a loan object and updates the timeOfReturn in database.
     * Returns nothing but logs error.
     * @param loan      takes a full Loan object
     */

    public static void updateReturnDateOnLoan(Loan loan){
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE loan SET" +
                " timeOfReturn = ?," +
                " WHERE id = ?;";
        LocalDate today = LocalDate.now();

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setString(1, today.toString());
            pstmt.setInt(2, loan.getLoanID());

            pstmt.executeUpdate();

        } catch (SQLException e){
            LOGGER.severe("updateReturnDateOnLoan " +e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

}
