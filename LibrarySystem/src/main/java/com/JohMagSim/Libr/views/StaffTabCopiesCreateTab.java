package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabCopiesCreateTab extends JComponent {
    private JLabel label = new JLabel("Create Copy");

    private JPanel form = new JPanel();

    private JPanel searchForm = new JPanel();
    private JLabel searchItem = new JLabel("Search item by isbn");
    private JTextField searchItemT = new JTextField(10);
    private JButton searchButton = new JButton("Search");

    private JLabel barcode = new JLabel("Barcode");
    private JTextField barcodeT = new JTextField(13);

    private JLabel state = new JLabel("State");
    private JComboBox stateT = new JComboBox();

    private JButton saveUser = new JButton("Save");
    private JButton clearForm = new JButton("Clear");

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JPanel getForm() {
        return form;
    }

    public void setForm(JPanel form) {
        this.form = form;
    }

    public JPanel getSearchForm() {
        return searchForm;
    }

    public void setSearchForm(JPanel searchForm) {
        this.searchForm = searchForm;
    }

    public JLabel getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(JLabel searchItem) {
        this.searchItem = searchItem;
    }

    public JTextField getSearchItemT() {
        return searchItemT;
    }

    public void setSearchItemT(JTextField searchItemT) {
        this.searchItemT = searchItemT;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JLabel getBarcode() {
        return barcode;
    }

    public void setBarcode(JLabel barcode) {
        this.barcode = barcode;
    }

    public JTextField getBarcodeT() {
        return barcodeT;
    }

    public void setBarcodeT(JTextField barcodeT) {
        this.barcodeT = barcodeT;
    }

    public JLabel getState() {
        return state;
    }

    public void setState(JLabel state) {
        this.state = state;
    }

    public JComboBox getStateT() {
        return stateT;
    }

    public void setStateT(JComboBox stateT) {
        this.stateT = stateT;
    }

    public JButton getSaveUser() {
        return saveUser;
    }

    public void setSaveUser(JButton saveUser) {
        this.saveUser = saveUser;
    }

    public JButton getClearForm() {
        return clearForm;
    }

    public void setClearForm(JButton clearForm) {
        this.clearForm = clearForm;
    }

    public StaffTabCopiesCreateTab(){

            setLayout(new BorderLayout());
            add(BorderLayout.NORTH, label);


            searchForm.add(searchItem);
            searchForm.add(searchItemT);
            searchForm.add(searchButton);
            add(BorderLayout.CENTER, searchForm);


            form.add(barcode);
            form.add(barcodeT);

            form.add(state);
            form.add(stateT);

            form.add(saveUser);
            form.add(clearForm);
            form.setVisible(false);
        }
}
