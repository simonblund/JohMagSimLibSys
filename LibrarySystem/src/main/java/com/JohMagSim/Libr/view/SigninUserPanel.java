package com.JohMagSim.Libr.view;

import com.JohMagSim.Libr.*;
import com.JohMagSim.Libr.controller.*;
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
        JSplitPane splitPanel = new JSplitPane();

        JPanel panelLeft = new JPanel(); // the panel is not visible in output
        panelLeft.setLayout(new BorderLayout());
        panelLeft.setBackground(ViewProperties.primaryColor);
        panelLeft.setVisible(true);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        panelRight.setBackground(ViewProperties.primaryColorLight);
        panelRight.setVisible(true);

        splitPanel.add(JSplitPane.LEFT, panelLeft);
        splitPanel.add(JSplitPane.RIGHT, panelRight);

        JLabel textLeft = new JLabel("Sign in");
        JButton signInStaff = new JButton("Staff sign in");

        panelLeft.add(BorderLayout.CENTER,textLeft);
        panelLeft.add(BorderLayout.SOUTH, signInStaff);

        gbc.fill = GridBagConstraints.HORIZONTAL;


        JLabel email = new JLabel("email");
        JLabel password = new JLabel("Password");

        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton signInButton = new JButton("Sign in");


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0.5;
        panelRight.add(email,gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0.5;
        gbc.insets=new Insets(10,0,0,0);
        panelRight.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0.5;
        panelRight.add(password,gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0.5;
        panelRight.add(passwordField,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.weightx = 0.5;
        panelRight.add(signInButton,gbc);


        // Text Area at the Center

        add(BorderLayout.CENTER, splitPanel);
        setVisible(true);
        setBackground(ViewProperties.primaryColorLight);



        // Actions

        ActionListener signInButtonPressed = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                char[] password = passwordField.getPassword();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (AuthControl.checkEmailExists(email)) {
                            try{
                                App.signedInUser = AuthControl.signIn(email, password);
                                setVisible(false);
                                setEnabled(false);
                            }
                            catch (Exception b){
                                emailField.setBackground(Color.red);
                                passwordField.setBackground(Color.red);
                            }

                        } else{
                            emailField.setToolTipText("Email & Password no matchy matchy");
                            emailField.setBackground(Color.red);
                            passwordField.setBackground(Color.red);
                        }

                    }
                });
                thread.run();
                updateUI();
            }
        };
        signInButton.addActionListener(signInButtonPressed);
        /*
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

         */
    }





}
