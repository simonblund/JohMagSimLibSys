package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabCopies extends JComponent {
    private JLabel label = new JLabel("Copy");
    private JTabbedPane copyTabs = new JTabbedPane();

    public JTabbedPane getCopyTabs() {
        return copyTabs;
    }

    public void setCopyTabs(JTabbedPane copyTabs) {
        this.copyTabs = copyTabs;
    }

    public StaffTabCopies(){
        setLayout(new BorderLayout());
        add(label);

    }
}
