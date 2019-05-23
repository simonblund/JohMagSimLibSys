package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabItemsEditTab extends JComponent {
    private JLabel label = new JLabel("Edit Item");

    public StaffTabItemsEditTab(){
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, label);
    }
}
