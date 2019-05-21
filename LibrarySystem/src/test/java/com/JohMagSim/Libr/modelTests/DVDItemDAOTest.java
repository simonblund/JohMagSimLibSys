package com.JohMagSim.Libr.modelTests;

import org.junit.Test;
import com.JohMagSim.Libr.model.*;

import java.util.ArrayList;
import java.util.List;

public class DVDItemDAOTest {

    public DVDItem testDVDitem1() {
        DVDItem dvdItem = new DVDItem("En film", "A1", "DVD", 1,
                2016, 1, 14, "12121212", "Drama", "Sweden", 15, testCreateTestActors());
        return dvdItem;
    }

    public List<String> testCreateTestActors() {
        ArrayList<String> actors = new ArrayList<>();
        actors.add("Dustin Hoffman");
        actors.add("Joaquin Phoenix");
        return actors;
    }

    //Tests under construction
    @Test
    public void itemSaveTest() {
        DVDItem test = testDVDitem1();
        int id = DVDItemDAO.createDVDItem(test);
        System.out.println(id);
    }


    @Test
    public void findDVDItem() {
        DVDItem test = testDVDitem1();
        int id = DVDItemDAO.createDVDItem(test);
        DVDItem dvdById = DVDItemDAO.findDVDbyId(id);
        System.out.println("Find by ID: " + dvdById); //for checking
    }

}




