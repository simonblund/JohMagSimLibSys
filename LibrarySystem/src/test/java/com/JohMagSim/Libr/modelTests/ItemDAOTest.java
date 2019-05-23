package com.JohMagSim.Libr.modelTests;

import com.JohMagSim.Libr.model.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ItemDAOTest {

    @Test
    public void findItembyId() {
        Item itemById = null;
        PaperItem paperItem=null;

        try {
            itemById=ItemDAO.findItembyId(156);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Find by ID: " + itemById); //for checking
    }


    @Test
    public void deleteItemById() {
        Item item = null; //Find item
        int idDelete=153;
        try {
            item = ItemDAO.findItembyId(idDelete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Find by ID in delete metod: " + item); //for checking
        if (item != null) {
            ItemDAO.deleteItemById(idDelete); //remove id
        } else {
            System.out.println("finns ej");
        }
    }
    @Test
    public void findItems(){
        String search="Super";
        ArrayList<Item> items = new ArrayList<>();
        items=ItemDAO.findItemsFromTitleAuthorsActorItemtypeCategory(search);
        System.out.println(items);
        System.out.println("Nr of rows for actors: " + items.size());


    }
}