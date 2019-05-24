package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class HomePanelVC {
    private HomePanel homepanel;

    public HomePanelVC(HomePanel panel){
        homepanel = panel;

    }

    public HomePanel getHomepanel(){
        //initHomePanel();

        return homepanel;
    }

    public void initHomePanel(){
        homepanel.getSearchButton().addActionListener(searchListener());
        homepanel.setVisible(true);
        homepanel.updateUI();
    }


    public ActionListener searchListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //PaperItemDAO

                // Simulated list below
                DefaultListModel listModel = new DefaultListModel();
                e.getActionCommand();
                ArrayList<Item> items = new ArrayList();
                items = ItemDAO.findItemsFromTitleAuthorsActorItemtypeCategory(homepanel.getSearch().getText());

                if (items.size()<1){

                    homepanel.getResultPanel().add(BorderLayout.CENTER, homepanel.getNoResults());
                    homepanel.updateUI();
                } else {
                    for(int i =0; i<items.size();i++){
                        listModel.addElement(items.get(i).getTitle()+" "+ items.get(i).getYear()+" "+items.get(i).getISBNEAN());

                    }
                    homepanel.getItemList().setModel(listModel);
                    homepanel.getResultPanel().add(BorderLayout.CENTER, homepanel.getItemList());
                    homepanel.updateUI();
                }

            }
        };
    }
}
