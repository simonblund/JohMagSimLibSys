package com.JohMagSim.Libr.view;

import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;

public class SigninUserPanel extends JPanel {


    public SigninUserPanel(){
        // Declares that the panel uses borderlayout to be able to use north south etc
        setLayout(new BorderLayout());


        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setBackground(ViewProperties.primaryColorLight);
        JLabel label = new JLabel("USER book");
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


            }
        });
    }





}
