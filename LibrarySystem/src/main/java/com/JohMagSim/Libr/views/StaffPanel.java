package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffPanel extends JPanel {
    JTabbedPane staffTabs = new JTabbedPane();

    public JTabbedPane getStaffTabs() {
        return staffTabs;
    }

    public void setStaffTabs(JTabbedPane staffTabs) {
        this.staffTabs = staffTabs;
    }

    public StaffPanel(){
        setLayout(new BorderLayout());

    }
}
