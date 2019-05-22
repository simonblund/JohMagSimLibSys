//to be done
package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.*;
import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.views.*;

import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;

public class CreateItemVC {
    private CreateItemPanel cip;

    public CreateItemVC(CreateItemPanel createItemPanel){
        cip = createItemPanel;
    }

    public CreateItemPanel getCip(){
        return cip;
    }

    public void initCreateItemPanel(){
        cip.getSaveDVDButton().addActionListener(saveDVDButtonPressed);
        cip.setVisible(true);
        cip.updateUI();
    }

    private ActionListener saveDVDButtonPressed = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = cip.getTitleTextField().getText();

            String location = "";
            String type = cip.getTypeTextField().getText();
            int edition = Integer.parseInt(cip.getEditionTextField().getText());
            int year = Integer.parseInt(cip.getYearTextfield().getText());

            int staffId = 99;
            int loanTime = Integer.parseInt(cip.getLoanTimeTextfield().getText());
            String ISBNEAN = cip.getISBNOrEANTextField().getText();
            String category = cip.getCategoryTextfield().getText();
            String prodCountry = cip.getProdCountryTextfield().getText();
            int ageRestriction = Integer.parseInt(cip.getAgeTextfield().getText());
            String actors = cip.getActorsTextfield().getText();

            String[] actorArray = actors.split(","); //common array created by split
            List actorArrayList = Arrays.asList(actorArray);//Change from array to list

            DVDItem dvdItem = new DVDItem(title, location, type, edition, year, staffId, loanTime, ISBNEAN, category, prodCountry, ageRestriction, actorArrayList);
            DVDItemDAO.createDVDItem(dvdItem);
        }
    };


}
