package com.JohMagSim.Libr.model;

import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Loan {

    //@TODO add variable copy + get/set when Copy is developed

    // Variables
    private LocalDate date;
    private LocalDate returnDate;
    //private Copy copy;


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



}