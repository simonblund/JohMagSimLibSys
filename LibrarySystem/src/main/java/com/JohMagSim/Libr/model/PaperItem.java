package com.JohMagSim.Libr.model;

import java.util.List;

public class PaperItem extends Item {

    private List<String> authors;

    public PaperItem(String title, String location, String type, int edition, int year, int staffId, int loantime, List<String> category, List<String> authors) {
        super(title, location, type, edition, year, staffId, loantime, category);
        this.authors = authors;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}


