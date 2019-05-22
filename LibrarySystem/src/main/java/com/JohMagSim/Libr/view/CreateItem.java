package com.JohMagSim.Libr.view;

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

public class CreateItem extends JFrame {

    public CreateItem(String title) {
        super(title);
        setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        JPanel middle = new JPanel();
        JPanel top = new JPanel();

        add(buttons, BorderLayout.SOUTH); //these lines add the bottom
        add(middle, BorderLayout.CENTER); //in the middle of the screen
        add(top, BorderLayout.NORTH); //at the top

        JButton saveDVDButton = new JButton("Create DVD-item");
        JButton cancelButton = new JButton("Cancel");

        JTextField titleTextField = new JTextField("Enter title");
        JTextField ISBNOrEANTextField = new JTextField("Enter ISBN or EAN");
        JTextField typeTextField = new JTextField("Enter type: DVD, CourseBook, Journal, ReferenceBook or regularBook");
        JTextField editionTextField = new JTextField("Enter edition");
        JTextField locationTextfield = new JTextField("Enter location");
        JTextField yearTextfield = new JTextField("Enter year");
        JTextField loanTimeTextfield = new JTextField("Enter loantime");
        JTextField categoryTextfield = new JTextField("Enter category, for example Action");
        JTextField prodCountryTextfield = new JTextField("Enter production country");
        JLabel age = new JLabel("Age restriction:");
        JTextField ageTextfield = new JTextField("enter for DVD");
        JLabel actors = new JLabel("Actors:");
        JTextField actorsTextfield = new JTextField("Separate actors by (,)");

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
        saveDVDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleTextField.getText();

                String location = "";
                String type = typeTextField.getText();
                int edition = Integer.parseInt(editionTextField.getText());
                int year = Integer.parseInt(yearTextfield.getText());

                int staffId = 99;
                int loanTime = Integer.parseInt(loanTimeTextfield.getText());
                String ISBNEAN = ISBNOrEANTextField.getText();
                String category = categoryTextfield.getText();
                String prodCountry = prodCountryTextfield.getText();
                int ageRestriction = Integer.parseInt(ageTextfield.getText());
                String actors = actorsTextfield.getText();

                String[] actorArray = actors.split(","); //common array created by split
                List actorArrayList = Arrays.asList(actorArray);//Change from array to list

                DVDItem dvdItem = new DVDItem(title, location, type, edition, year, staffId, loanTime, ISBNEAN, category, prodCountry, ageRestriction, actorArrayList);
                DVDItemDAO.createDVDItem(dvdItem);
            }
        });


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CloseFrame();
            }
        });


        pack();
        setMinimumSize(dimension);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void CloseFrame() {
        super.dispose();
    }
}
