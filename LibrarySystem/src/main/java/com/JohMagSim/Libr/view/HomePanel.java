package com.JohMagSim.Libr.view;

import com.JohMagSim.Libr.utils.*;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

/*
    public HomePanel(){
        homepanel.setLayout(new BorderLayout());
        homepanel.setSize(ViewProperties.dimension);
        loginButton.setText("Sign in");
        searchField.setToolTipText("Search for book or other item");
        searchButton.setText("Search");
        homepanel.setBackground(ViewProperties.primaryColor);
        homepanel.setForeground(ViewProperties.primaryWhite);
        setBackground(ViewProperties.primaryColor);
        setVisible(true);
        add(homepanel);
    }

 */

    public HomePanel(){
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Search for book");
        JTextField search = new JTextField(10); // accepts upto 10 characters
        JButton searchButton = new JButton("Search");
        JButton signinButton = new JButton("Sign in");
        panel.add(label); // Components Added using Flow Layout
        panel.add(label); // Components Added using Flow Layout
        panel.add(search);
        panel.add(searchButton);
        panel.add(signinButton);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        add(BorderLayout.SOUTH, panel);
        add(BorderLayout.NORTH, mb);
        add(BorderLayout.CENTER, ta);
        setVisible(true);
    }



}
