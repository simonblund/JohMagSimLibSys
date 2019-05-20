package com.JohMagSim.Libr.view;

import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class HomePanel extends JPanel {
    //@TODO Make search work and connect to itemDAO.


    public HomePanel(){
        // Declares that the panel uses borderlayout to be able to use north south etc
        setLayout(new BorderLayout());


        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setBackground(ViewProperties.primaryColorLight);
        JLabel label = new JLabel("Search for book");
        JLabel noResults = new JLabel("No results");
        JTextField search = new JTextField(10); // accepts upto 10 characters
        JButton searchButton = new JButton("Search");
        JList itemList = new JList(){};
        panel.add(label); // Components Added using Flow Layout
        panel.add(label); // Components Added using Flow Layout
        panel.add(search);
        panel.add(searchButton);

        // Text Area at the Center


        //Adding Components to the frame.
        add(BorderLayout.NORTH, panel);
        add(BorderLayout.CENTER, resultPanel);
        setVisible(true);
        setBackground(ViewProperties.primaryColorLight);



        // Actions

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //PaperItemDAO

                // Simulated list below
                DefaultListModel listModel = new DefaultListModel();
                e.getActionCommand();
                ArrayList<Item> items = new ArrayList();

                List authors = new ArrayList();
                authors.add("Steven Hawking");

                items.add(new PaperItem("Harry Potter 2", "LB23", "Book", 3, 2019, 1, 14, "141414141414", "example", authors));

                if (items.size()<1){
                    resultPanel.add(BorderLayout.CENTER, noResults);
                    updateUI();
                } else {
                    for(int i =0; i<items.size();i++){
                        listModel.addElement(items.get(i).getTitle()+" "+ items.get(i).getYear());

                    }
                    itemList.setModel(listModel);
                    resultPanel.add(BorderLayout.CENTER, itemList);
                    updateUI();
                }

            }
        });
    }





}
