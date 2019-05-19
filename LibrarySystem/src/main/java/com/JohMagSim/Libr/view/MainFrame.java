package com.JohMagSim.Libr.view;

import com.JohMagSim.Libr.utils.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import static com.JohMagSim.Libr.utils.ViewProperties.dimension;

public class MainFrame extends JFrame {
    private HomePanel homePanel;
    private SigninUserPanel signinUserPanel;

    public MainFrame(String title){
        super(title);

        setLayout(new BorderLayout());
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        JMenu m3 = new JMenu("Sign in");
        mb.add(m1);
        mb.add(m2);

        homePanel = new HomePanel();
        signinUserPanel = new SigninUserPanel();
        add(BorderLayout.CENTER, homePanel);

        m3.addMenuListener(new MenuListener() {
            public void menuSelected(MenuEvent e) {
                homePanel.setVisible(false);
                add(BorderLayout.CENTER, signinUserPanel);

            }
            public void menuDeselected(MenuEvent event){}
            public void menuCanceled(MenuEvent e){}
        });
        mb.add(m3);

        add(BorderLayout.NORTH, mb);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(dimension);
        setVisible(true);

        setBackground(ViewProperties.primaryColor);

    }

}
