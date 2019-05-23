package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabCopiesEditTab extends JComponent {
    private JLabel label = new JLabel("Edit Copy");

    public StaffTabCopiesEditTab(){
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, label);
    }
}
