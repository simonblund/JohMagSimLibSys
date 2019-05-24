package com.JohMagSim.Libr.model;

public class Copy {

    private int id;
    private int itemID;
    private String barCode;
    private int state; //Enum? Skulle kunna vara Enum i .java
    // och int i SQLLite då SQLLite inte kan hantera Enum


    public Copy(int itemID, String barCode, int state) {
        this.itemID = itemID;
        this.barCode = barCode;
        this.state = state;
    }

    public Copy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Copy{" +
                "itemID=" + itemID +
                ", barCode=" + barCode +
                ", state=" + state +
                '}';
    }
}

