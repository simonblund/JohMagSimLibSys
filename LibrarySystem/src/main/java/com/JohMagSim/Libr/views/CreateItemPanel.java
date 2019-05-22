package com.JohMagSim.Libr.views;

import com.JohMagSim.Libr.model.DVDItem;
import com.JohMagSim.Libr.model.DVDItemDAO;
import com.JohMagSim.Libr.utils.ViewProperties;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.JohMagSim.Libr.utils.ViewProperties.dimension;

public class CreateItemPanel extends JPanel {
    private JPanel buttons = new JPanel();
    private JPanel middle = new JPanel();
    private JPanel top = new JPanel();
    private JButton saveDVDButton = new JButton("Create DVD-item");
    private JButton cancelButton = new JButton("Cancel");

    private JTextField titleTextField = new JTextField("Enter title");
    private JTextField ISBNOrEANTextField = new JTextField("Enter ISBN or EAN");
    private JTextField typeTextField = new JTextField("Enter type: DVD, CourseBook, Journal, ReferenceBook or regularBook");
    private JTextField editionTextField = new JTextField("Enter edition");
    private JTextField locationTextfield = new JTextField("Enter location");
    private JTextField yearTextfield = new JTextField("Enter year");

    private JTextField loanTimeTextfield = new JTextField("Enter loantime");
    private JTextField categoryTextfield = new JTextField("Enter category, for example Action");
    private JTextField prodCountryTextfield = new JTextField("Enter production country");
    private JLabel age = new JLabel("Age restriction:");
    private JTextField ageTextfield = new JTextField("enter for DVD");
    private JLabel actors = new JLabel("Actors:");
    private JTextField actorsTextfield = new JTextField("Separate actors by (,)");


    public JPanel getButtons() {
        return buttons;
    }

    public void setButtons(JPanel buttons) {
        this.buttons = buttons;
    }

    public JPanel getMiddle() {
        return middle;
    }

    public void setMiddle(JPanel middle) {
        this.middle = middle;
    }

    public JPanel getTop() {
        return top;
    }

    public void setTop(JPanel top) {
        this.top = top;
    }

    public JButton getSaveDVDButton() {
        return saveDVDButton;
    }

    public void setSaveDVDButton(JButton saveDVDButton) {
        this.saveDVDButton = saveDVDButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JTextField getTitleTextField() {
        return titleTextField;
    }

    public void setTitleTextField(JTextField titleTextField) {
        this.titleTextField = titleTextField;
    }

    public JTextField getISBNOrEANTextField() {
        return ISBNOrEANTextField;
    }

    public void setISBNOrEANTextField(JTextField ISBNOrEANTextField) {
        this.ISBNOrEANTextField = ISBNOrEANTextField;
    }

    public JTextField getTypeTextField() {
        return typeTextField;
    }

    public void setTypeTextField(JTextField typeTextField) {
        this.typeTextField = typeTextField;
    }

    public JTextField getEditionTextField() {
        return editionTextField;
    }

    public void setEditionTextField(JTextField editionTextField) {
        this.editionTextField = editionTextField;
    }

    public JTextField getLocationTextfield() {
        return locationTextfield;
    }

    public void setLocationTextfield(JTextField locationTextfield) {
        this.locationTextfield = locationTextfield;
    }

    public JTextField getYearTextfield() {
        return yearTextfield;
    }

    public void setYearTextfield(JTextField yearTextfield) {
        this.yearTextfield = yearTextfield;
    }

    public JTextField getLoanTimeTextfield() {
        return loanTimeTextfield;
    }

    public void setLoanTimeTextfield(JTextField loanTimeTextfield) {
        this.loanTimeTextfield = loanTimeTextfield;
    }

    public JTextField getCategoryTextfield() {
        return categoryTextfield;
    }

    public void setCategoryTextfield(JTextField categoryTextfield) {
        this.categoryTextfield = categoryTextfield;
    }

    public JTextField getProdCountryTextfield() {
        return prodCountryTextfield;
    }

    public void setProdCountryTextfield(JTextField prodCountryTextfield) {
        this.prodCountryTextfield = prodCountryTextfield;
    }

    public JLabel getAge() {
        return age;
    }

    public void setAge(JLabel age) {
        this.age = age;
    }

    public JTextField getAgeTextfield() {
        return ageTextfield;
    }

    public void setAgeTextfield(JTextField ageTextfield) {
        this.ageTextfield = ageTextfield;
    }

    public JLabel getActors() {
        return actors;
    }

    public void setActors(JLabel actors) {
        this.actors = actors;
    }

    public JTextField getActorsTextfield() {
        return actorsTextfield;
    }

    public void setActorsTextfield(JTextField actorsTextfield) {
        this.actorsTextfield = actorsTextfield;
    }


    public CreateItemPanel() {
        setLayout(new BorderLayout());
        setVisible(true);
        add(buttons, BorderLayout.SOUTH); //these lines add the bottom
        add(middle, BorderLayout.CENTER); //in the middle of the screen
        add(top, BorderLayout.NORTH); //at the top



        buttons.add(saveDVDButton);
        buttons.add(cancelButton);
        top.add(titleTextField);
        top.add(ISBNOrEANTextField);
        top.add(typeTextField);
        top.add(categoryTextfield);
        middle.add(age);
        middle.add(ageTextfield);
        middle.add(editionTextField);
        middle.add(yearTextfield);
        middle.add(loanTimeTextfield);
        middle.add(prodCountryTextfield);
        middle.add(actors);
        middle.add(actorsTextfield);
        middle.add(locationTextfield);

    }
}
