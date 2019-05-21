package com.JohMagSim.Libr.modelTests;

import org.junit.Test;
import com.JohMagSim.Libr.model.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DVDItemDAOTest {

    public DVDItem testDVDitem1() {
        //instanserar
        DVDItem dvdItem = new DVDItem("En film", "A1", "DVD", 1,
                2016, 1, 14, "12121212", "Drama", "Sweden", 15, testCreateTestActors());
        return dvdItem;
    }

    public DVDItem testDVDitemUpdate() {
        //instanserar
        DVDItem dvdItem = new DVDItem("Superstar", "A3", "DVD", 1,
                2018, 1, 14, "222", "Action", "USA", 15, testCreateTestActorsUpdate());
        return dvdItem;
    }


    public List<String> testCreateTestActors() {
        ArrayList<String> actors = new ArrayList<>();
        actors.add("Dustin Hoffman");
        actors.add("Joaquin Phoenix");
        return actors;
    }

    public List<String> testCreateTestActorsUpdate() {
        ArrayList<String> actors = new ArrayList<>();
        actors.add("Arnold Schwarzenegger");
        actors.add("Joaquin Phoenix");
        return actors;
    }

    //Tests under construction
    @Test
    public void itemSaveTest() {
        DVDItem test = testDVDitem1(); //instans
        int id = DVDItemDAO.createDVDItem(test); //skickar in test-instans för att skapa en item i DB. Denna metod returnerar en int
        System.out.println(id);
    }


    @Test
    public void findDVDItemTest() {
        DVDItem test = testDVDitem1();
        int id = DVDItemDAO.createDVDItem(test);
        DVDItem dvdById = DVDItemDAO.findDVDbyId(id);
        System.out.println("Find by ID: " + dvdById); //for checking
    }

    @Test
    public void deleteDVDItemTest() {

        DVDItem dvdItem = DVDItemDAO.findDVDbyId(50); //Find item
        System.out.println("Find by ID in delete metod: " + dvdItem); //for checking
        if (dvdItem != null) {
            DVDItemDAO.deleteDVDById(50); //remove id
        } else {
            System.out.println("finns ej");
        }
    }

    @Test
    public void updateDVDitemTest() {
        DVDItem test = testDVDitemUpdate(); //instans
        int id = DVDItemDAO.uppdateDVDItem(test, 51); //skickar in test-instans för att skapa en item i DB. Denna metod returnerar en int
        System.out.println(id);
    }

    @Test
    public void findDVDfromActor() {

        String actor = "Joa";
        ArrayList<DVDItem> dvds = new ArrayList<>();
        dvds = DVDItemDAO.findDVDFromActor(actor);
        System.out.println(dvds);
        System.out.println("Nr of rows for actors: " + dvds.size());

    }

    @Test
    public void findDVDfromTitle() {

        String title = "Super";
        ArrayList<DVDItem> dvds = new ArrayList<>();
        dvds = DVDItemDAO.findDVDFromTitle(title);
        System.out.println(dvds);
        System.out.println("Nr of rows for title: " + dvds.size());

    }

    @Test
    public void findDVDfromTitleActorCountyAgeCategory() {
        String title = "";
        String actor = "Ar";
        String county = "";
        int age = 15;
        String category = "Ac";

        ArrayList<DVDItem> dvds = new ArrayList<>();
        dvds =
                DVDItemDAO.findDVDFromTitleActorCountyAgeCategory
                        (title, actor, county, age, category);

        System.out.println(dvds);
        System.out.println("Nr of rows for multiple search: " + dvds.size());

    }
}



