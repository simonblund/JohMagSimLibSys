package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabLoans extends JComponent{
    private JLabel label = new JLabel("Loan");
    private JTabbedPane loanTabs = new JTabbedPane();

    public JTabbedPane getItemTabs() {
        return loanTabs;
    }

    public void setLoanTabs(JTabbedPane itemTabs) {
        this.loanTabs = itemTabs;
    }

    public StaffTabLoans(){
        setLayout(new BorderLayout());
        add(label);

    }
}
