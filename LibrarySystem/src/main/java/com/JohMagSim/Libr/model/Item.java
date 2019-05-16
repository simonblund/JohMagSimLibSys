package com.JohMagSim.Libr.model;

import java.util.List;

public abstract class Item {

    private String title;
    private String location;
    private String type;
    private int edition;
    private int year;
    private int staffId;
    private int loantime;
    private List<String> category;

    public Item(String title, String location, String type, int edition, int year, int staffId, int loantime, List<String> category) {
        this.title = title;
        this.location = location;
        this.type = type;
        this.edition = edition;
        this.year = year;
        this.staffId = staffId;
        this.loantime = loantime;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getLoantime() {
        return loantime;
    }

    public void setLoantime(int loantime) {
        this.loantime = loantime;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", edition=" + edition +
                ", year=" + year +
                ", staffId=" + staffId +
                ", loantime=" + loantime +
                ", category=" + category +
                '}';
    }
}
