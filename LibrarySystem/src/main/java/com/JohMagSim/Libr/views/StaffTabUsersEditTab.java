package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabUsersEditTab extends JComponent{
    private JLabel label = new JLabel("Edit user");

    public StaffTabUsersEditTab(){
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, label);
    }
}
