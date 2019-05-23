package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabItems extends JComponent {
    private JLabel label = new JLabel("Item");
    private JTabbedPane itemTabs = new JTabbedPane();

    public JTabbedPane getItemTabs() {
        return itemTabs;
    }

    public void setItemTabs(JTabbedPane itemTabs) {
        this.itemTabs = itemTabs;
    }

    public StaffTabItems(){
        setLayout(new BorderLayout());
        add(label);

    }

}
