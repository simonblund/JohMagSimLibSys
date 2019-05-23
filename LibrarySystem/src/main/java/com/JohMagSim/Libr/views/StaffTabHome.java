package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabHome extends JComponent {
    private JLabel staff= new JLabel("StaffTab");

    public StaffTabHome(){
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH,staff);

    }

}
