package com.JohMagSim.Libr.modelTests;

import com.JohMagSim.Libr.model.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PaperItemDAOTest {

    public PaperItem testPaperitem1() {
        PaperItem paperItem = new PaperItem("En saga", "G1","Övriga böcker",
                2, 2018, 0, 30, "1111", "Skönlitteratur", testCreateTestAuthors());
        return paperItem;
    }

    private ArrayList<String> testCreateTestAuthors(){
        ArrayList<String>authors=new ArrayList<>();
        authors.add("Astrid Lindgren");
        authors.add("Tove Lindgren");
        return authors;
    }

    //Tests under construction
    @Test
    public void testCreatePaperItem() {
    PaperItem testPaperitem=testPaperitem1();
    int id=PaperItemDAO.createPaperItem(testPaperitem);
    System.out.println(id);//does the method generate a positive int?
    }

    @Test
    public void testFindpaperItembyId() {
        PaperItem testPaperitem=testPaperitem1();
        int id=PaperItemDAO.createPaperItem(testPaperitem);
        PaperItem paperItemByid=PaperItemDAO.findpaperItembyId(id);
        System.out.println(paperItemByid);
    }
}