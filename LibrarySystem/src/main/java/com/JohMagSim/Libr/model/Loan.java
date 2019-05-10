package com.JohMagSim.Libr.model;

import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Loan {

    // Variables
    private int loanId;
    private LocalDate date;
    private LocalDate returnDate;
    private int copyID;
    private int userID;

    public Loan(){
        super();
    }

    public Loan(int loanId, LocalDate date, LocalDate returnDate, int copyID, int userID){
        this.loanId = loanId;
        this.date = date;
        this.returnDate = returnDate;
        this.copyID = copyID;
        this.userID = userID;
    }


    // Setters & Getters

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getCopyID() {
        return copyID;
    }

    public void setCopyID(int copyID) {
        this.copyID = copyID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUser(int userID) {
        this.userID = userID;
    }

    //TODO override toString-method?

}