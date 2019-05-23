package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabUsersCreateTab extends JComponent {
    private JLabel label = new JLabel("Create user");
    private JPanel form = new JPanel();

    private JLabel firstname = new JLabel("Firstname");
    private JLabel lastname = new JLabel("Lastname");
    private JLabel email = new JLabel("Email");
    private JLabel password = new JLabel("Password");
    private JLabel usertype = new JLabel("Usertype");




    public StaffTabUsersCreateTab(){
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, label);
        add(BorderLayout.CENTER,form);

        form.setLayout(new SpringLayout());
        add(firstname,SpringLayout.NORTH);
    }
}
