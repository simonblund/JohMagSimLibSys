package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabUsersEditTab extends JComponent{
    private JLabel label = new JLabel("Edit user");
    private JPanel form = new JPanel();

    private JPanel searchForm = new JPanel();
    private JLabel searchEmail = new JLabel("Search user by email");
    private JTextField searchuser = new JTextField(10);
    private JButton searchButton = new JButton("Search");

    private JLabel firstname = new JLabel("Firstname");
    private JLabel lastname = new JLabel("Lastname");
    private JLabel email = new JLabel("Email");
    private JLabel password = new JLabel("Password");
    private JLabel usertype = new JLabel("Usertype");

    private JTextField firstnameT = new JTextField(10);
    private JTextField lastnameT = new JTextField(10);
    private JTextField emailT = new JTextField(10);
    private JPasswordField passwordT = new JPasswordField(10);
    private JComboBox usertypeT = new JComboBox();

    private JButton saveUser = new JButton("Save");
    private JButton clearForm = new JButton("Clear");

    public JPanel getSearchForm() {
        return searchForm;
    }

    public void setSearchForm(JPanel searchForm) {
        this.searchForm = searchForm;
    }

    public JTextField getSearchuser() {
        return searchuser;
    }

    public void setSearchuser(JTextField searchuser) {
        this.searchuser = searchuser;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

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

    public JLabel getFirstname() {
        return firstname;
    }

    public void setFirstname(JLabel firstname) {
        this.firstname = firstname;
    }

    public JLabel getLastname() {
        return lastname;
    }

    public void setLastname(JLabel lastname) {
        this.lastname = lastname;
    }

    public JLabel getEmail() {
        return email;
    }

    public void setEmail(JLabel email) {
        this.email = email;
    }

    public JLabel getPassword() {
        return password;
    }

    public void setPassword(JLabel password) {
        this.password = password;
    }

    public JLabel getUsertype() {
        return usertype;
    }

    public void setUsertype(JLabel usertype) {
        this.usertype = usertype;
    }

    public JTextField getFirstnameT() {
        return firstnameT;
    }

    public void setFirstnameT(JTextField firstnameT) {
        this.firstnameT = firstnameT;
    }

    public JTextField getLastnameT() {
        return lastnameT;
    }

    public void setLastnameT(JTextField lastnameT) {
        this.lastnameT = lastnameT;
    }

    public JTextField getEmailT() {
        return emailT;
    }

    public void setEmailT(JTextField emailT) {
        this.emailT = emailT;
    }

    public JPasswordField getPasswordT() {
        return passwordT;
    }

    public void setPasswordT(JPasswordField passwordT) {
        this.passwordT = passwordT;
    }

    public JComboBox getUsertypeT() {
        return usertypeT;
    }

    public void setUsertypeT(JComboBox usertypeT) {
        this.usertypeT = usertypeT;
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

    public StaffTabUsersEditTab(){
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, label);


        searchForm.add(searchEmail);
        searchForm.add(searchuser);
        searchForm.add(searchButton);
        add(BorderLayout.CENTER, searchForm);


        firstname.setLabelFor(firstnameT);
        form.add(firstname);
        form.add(firstnameT);

        form.add(lastname);
        form.add(lastnameT);

        form.add(email);
        form.add(emailT);

        form.add(usertype);
        form.add(usertypeT);

        form.add(saveUser);
        form.add(clearForm);
        form.setVisible(false);
    }
}
