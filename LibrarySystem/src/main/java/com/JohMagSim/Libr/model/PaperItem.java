package com.JohMagSim.Libr.model;

import java.util.List;

public class PaperItem extends Item {

    private List<String> authors;

    //constructor without itemid
    public PaperItem(String title, String location, String type, int edition, int year, int staffId, int loantime, String ISBNEAN, String category, List<String> authors) {
        super(title, location, type, edition, year, staffId, loantime, ISBNEAN, category);
        this.authors = authors;
    }

    //constructor with id
    public PaperItem() {
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {

        return super.toString() + "PaperItem{" +
                "authors=" + authors +
                '}';
    }
}


