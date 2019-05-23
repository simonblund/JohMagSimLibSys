package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabCopiesCreateTab extends JComponent {
    private JLabel label = new JLabel("Create Copy");

    public StaffTabCopiesCreateTab(){
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, label);
    }
}
