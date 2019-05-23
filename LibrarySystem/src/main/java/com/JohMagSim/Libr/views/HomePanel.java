package com.JohMagSim.Libr.views;

import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.utils.*;
import com.JohMagSim.Libr.viewcontroller.*;

import javax.swing.*;
import java.awt.*;


public class HomePanel extends JPanel{
    private JPanel panel = new JPanel();
    private JPanel resultPanel = new JPanel();
    private JLabel label = new JLabel("Search for book");
    private JLabel noResults = new JLabel("No results");
    private JTextField search = new JTextField(10); // accepts upto 10 characters
    private JButton searchButton = new JButton("Search");
    private JList itemList = new JList(){};
    private HomePanelVC hvc;

    public HomePanelVC getHvc() {
        return hvc;
    }

    public void setHvc(HomePanelVC hvc) {
        this.hvc = hvc;
    }




    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getResultPanel() {
        return resultPanel;
    }

    public void setResultPanel(JPanel resultPanel) {
        this.resultPanel = resultPanel;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JLabel getNoResults() {
        return noResults;
    }

    public void setNoResults(JLabel noResults) {
        this.noResults = noResults;
    }

    public JTextField getSearch() {
        return search;
    }

    public void setSearch(JTextField search) {
        this.search = search;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JList getItemList() {
        return itemList;
    }

    public void setItemList(JList itemList) {
        this.itemList = itemList;
    }

    public HomePanel(){
        setLayout(new BorderLayout());
        setVisible(true);
        setBackground(ViewProperties.primaryColorLight);


        panel.add(label); // Components Added using Flow Layout
        panel.add(label); // Components Added using Flow Layout
        panel.add(search);
        panel.add(searchButton);

        resultPanel.setLayout(new BorderLayout());
        resultPanel.setBackground(ViewProperties.primaryColorLight);
        add(BorderLayout.NORTH, panel);
        add(BorderLayout.CENTER, resultPanel);

    }



    //Creating the panel at bottom and adding components
     // the panel is not visible in output





    // Text Area at the Center


    //Adding Components to the frame.




    // Actions


}
