package com.JohMagSim.Libr.model;

import java.time.LocalDate;

public class Loan {

    // Variables
    private int loanID;
    private LocalDate date;
    private LocalDate actualReturnDate;
    private LocalDate expectedReturnDate;
    private int copyID;
    private int userID;

    public Loan(){
        super();
    }

    public Loan(int loanID, LocalDate date, LocalDate actualReturnDate, LocalDate expectedReturnDate, int copyID, int userID){
        this.loanID = loanID;
        this.date = date;
        this.expectedReturnDate = expectedReturnDate;
        this.actualReturnDate = actualReturnDate;
        this.copyID = copyID;
        this.userID = userID;
    }

    //toString
    @Override
    public String toString() {
        return "Loan{" +
                "loanID=" + loanID +
                ", copyID=" + copyID  +
                ", userID=" + userID +
                ", timeOfCheckout=" + date +
                ", timeOfExpectedReturn=" + expectedReturnDate +
                ", timeOfReturn=" + actualReturnDate +
                '}';
    }

    // Setters & Getters

    public int getLoanID() {
        return loanID;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
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

    public void setUserID(int userID) {
        this.userID = userID;
    }


}