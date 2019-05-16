package com.JohMagSim.Libr.model;

public class Copy {

    //skapar items i DB
    private int itemID;
    private int barCode;
    private int state; //Enum? Skulle kunna vara Enum i .java
    // och int i SQLLite då SQLLite inte kan hantera Enum

    public Copy(int itemID, int barCode, int state) {
        this.itemID = itemID;
        this.barCode = barCode;
        this.state = state;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
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

