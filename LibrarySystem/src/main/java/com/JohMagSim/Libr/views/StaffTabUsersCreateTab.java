package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabUsersCreateTab extends JComponent {
    private JLabel label = new JLabel("Create user");

    public StaffTabUsersCreateTab(){
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, label);
    }
}
