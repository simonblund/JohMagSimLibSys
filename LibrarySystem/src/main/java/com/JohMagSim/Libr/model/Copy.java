package main.java.com.JohMagSim.Libr.model;

public class Copy {
    private int itemID;
    private String title;
    private int barCode;
    private String location;
    private String classification;
    private int state; //Enum? Skulle kunna vara Enum i .java
    // och int i SQLLite då SQLLite inte kan hantera Enum
    private boolean onLoan;

    public Copy(int itemID, String title, int barCode, String location, String classification, int state, boolean onLoan) {
        this.itemID = itemID;
        this.title = title;
        this.barCode = barCode;
        this.location = location;
        this.classification = classification;
        this.state = state;
        this.onLoan = onLoan;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    @Override
    public String toString() {
        return "Copy{" +
                "itemID=" + itemID +
                ", title='" + title + '\'' +
                ", barCode=" + barCode +
                ", location='" + location + '\'' +
                ", classification='" + classification + '\'' +
                ", state=" + state +
                ", onLoan=" + onLoan +
                '}';
    }
}

