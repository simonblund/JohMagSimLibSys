package com.JohMagSim.Libr.model;

import java.util.List;

public class DVDItem extends Item {
    private String prodCountry;
    private int ageRestriction;
    private List<String> actors;

    public DVDItem(String title, String location, String type, int edition, int year, int staffId, int loantime, List<String> category, String prodCountry, int ageRestriction, List<String> actors) {
        super(title, location, type, edition, year, staffId, loantime, category);
        this.prodCountry = prodCountry;
        this.ageRestriction = ageRestriction;
        this.actors = actors;
    }

    public String getProdCountry() {
        return prodCountry;
    }

    public void setProdCountry(String prodCountry) {
        this.prodCountry = prodCountry;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "DVDItem{" +
                "prodCountry='" + prodCountry + '\'' +
                ", ageRestriction=" + ageRestriction +
                ", actors=" + actors +
                '}';
    }
}


