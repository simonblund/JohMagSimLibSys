package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.views.*;

import java.awt.event.*;
import java.util.*;

public class StaffTabItemsCreateTabVC {
    private StaffTabItemsCreateTab cip;

    public StaffTabItemsCreateTabVC(StaffTabItemsCreateTab createItemPanel){
        cip = createItemPanel;
    }

    public StaffTabItemsCreateTab getCip(){
        return cip;
    }

    public void initStaffTabItemsCreateTab(){
        cip.getSaveDVDButton().addActionListener(saveDVDButtonPressed);
        cip.getCancelButton().addActionListener(cancelButtonPressed);
        cip.setVisible(true);
        cip.updateUI();
    }

    private ActionListener saveDVDButtonPressed = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = cip.getTitleTextField().getText();
            int edition = Integer.parseInt(cip.getEditionTextField().getText());
            int year = Integer.parseInt(cip.getYearTextfield().getText());
            int staffId = 99;
            String location=cip.getLocationTextfield().getText();
            String type = (String) cip.getItemType().getSelectedItem();
            String ISBNEAN = cip.getISBNOrEANTextField().getText();
            String category = cip.getCategoryTextfield().getText();

            if(type.equals("DVD")) {
                int loanTime = 7;
                int ageRestriction;
                String prodCountry = cip.getProdCountryTextfield().getText();
                String stringAgeRestriction = cip.getAgeTextfield().getText();
                if(stringAgeRestriction.equals(""))
                {
                   ageRestriction=0;
                }
                else
                    ageRestriction= Integer.parseInt(stringAgeRestriction);
                String actors = cip.getActorsTextfield().getText();
                String[] actorArray = actors.split(","); //common array created by split
                List actorArrayList = Arrays.asList(actorArray);//Change from array to list

                DVDItem dvdItem = new DVDItem(title, location, type, edition, year, staffId, loanTime, ISBNEAN, category, prodCountry, ageRestriction, actorArrayList);
                DVDItemDAO.createDVDItem(dvdItem);
            }
            if(type.equals("Course book") || type.equals("Journal") || type.equals("Reference book") || type.equals("Regular book"))
            {
                int loanTime=0;
                if(type.equals("Course book"))
                {loanTime=14;}
                if(type.equals("Regular book"))
                    loanTime=30;

                String authors = cip.getActorsTextfield().getText();
                String[] authorArray = authors.split(","); //common array created by split
                List authorArrayList = Arrays.asList(authorArray);//Change from array to list
                PaperItem paperItem = new PaperItem(title, location, type, edition, year, staffId, loanTime, ISBNEAN, category, authorArrayList);
                PaperItemDAO.createPaperItem(paperItem);
            }

        }
    };
    private ActionListener cancelButtonPressed = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cip.getTitleTextField().setText("");
            cip.getEditionTextField().setText("");
            cip.getYearTextfield().setText("");
            cip.getAgeTextfield().setText("");
            cip.getLocationTextfield().setText("");
            cip.getItemType().setSelectedIndex(0);
            cip.getISBNOrEANTextField().setText("");
            cip.getCategoryTextfield().setText("");
            cip.getActorsTextfield().setText("");
            cip.getProdCountryTextfield().setText("");
        }
    };
}
