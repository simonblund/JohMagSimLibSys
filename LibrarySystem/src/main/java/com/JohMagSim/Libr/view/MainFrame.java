package com.JohMagSim.Libr.view;

import com.JohMagSim.Libr.utils.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private HomePanel homePanel;
    public MainFrame(String title){
        super(title);
        homePanel = new HomePanel();

        Dimension dimension = new Dimension();
        dimension.setSize(ViewProperties.width,ViewProperties.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(dimension);
        setVisible(true);
        setLayout(new BorderLayout());
        setBackground(ViewProperties.primaryColor);
        setContentPane(homePanel);

    }

}
