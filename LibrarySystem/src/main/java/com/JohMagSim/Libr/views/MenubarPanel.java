package com.JohMagSim.Libr.views;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class MenubarPanel extends JMenuBar {
    private  JMenu m1 = new JMenu("FILE");
    private  JMenu m2 = new JMenu("Help");
    private  JMenu m3 = new JMenu("Sign in");
    private JMenu m4 = new JMenu("Sign out");

    public JMenu getM1() {
        return m1;
    }

    public void setM1(JMenu m1) {
        this.m1 = m1;
    }

    public JMenu getM2() {
        return m2;
    }

    public void setM2(JMenu m2) {
        this.m2 = m2;
    }

    public JMenu getM3() {
        return m3;
    }

    public void setM3(JMenu m3) {
        this.m3 = m3;
    }

    public JMenu getM4() {
        return m4;
    }

    public void setM4(JMenu m4) {
        this.m4 = m4;
    }



    public MenubarPanel(){
        add(m1);
        add(m2);
        setVisible(true);
    }
}
