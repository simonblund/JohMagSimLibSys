package com.JohMagSim.Libr.views;

import com.JohMagSim.Libr.utils.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

import static com.JohMagSim.Libr.utils.ViewProperties.dimension;

public class Frame extends JFrame {


    private MenubarPanel north;
    private JPanel south;
    private JPanel west;
    private JPanel center;
    private JPanel east;

    public MenubarPanel getNorth() {
        return north;
    }

    public void setNorth(MenubarPanel north) {
        this.north = north;
    }

    public JPanel getSouth() {
        return south;
    }

    public void setSouth(JPanel south) {
        this.south = south;
    }

    public JPanel getWest() {
        return west;
    }

    public void setWest(JPanel west) {
        this.west = west;
    }

    public JPanel getCenter() {
        return center;
    }

    public void setCenter(JPanel center) {
        this.center = center;
    }

    public JPanel getEast() {
        return east;
    }

    public void setEast(JPanel east) {
        this.east = east;
    }

    public Frame(String title){
        super(title);
        setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(dimension);
    }


}

