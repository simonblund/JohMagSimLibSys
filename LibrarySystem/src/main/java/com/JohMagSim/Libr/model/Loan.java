package com.JohMagSim.Libr.model;

import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Loan {

    // Variables
    private LocalDate date;
    private LocalDate returnDate;
    private Copy copy;
    private User user;


    // Setters & Getters

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

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}