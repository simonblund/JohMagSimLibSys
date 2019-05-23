package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabUsers extends JComponent {
    private JLabel label = new JLabel("User");
    private JTabbedPane userTabs = new JTabbedPane();

    public JTabbedPane getUserTabs() {
        return userTabs;
    }

    public void setUserTabs(JTabbedPane copyTabs) {
        this.userTabs = userTabs;
    }

    public StaffTabUsers(){
        setLayout(new BorderLayout());
        add(label);

    }
}
