package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabUsersStaffCreateTab extends JComponent {
    private JLabel label = new JLabel("Create staff");
    private JPanel form = new JPanel();

    private JLabel firstname = new JLabel("Firstname");
    private JLabel lastname = new JLabel("Lastname");
    private JLabel email = new JLabel("Email");
    private JLabel password = new JLabel("Password");
    private JLabel usertype = new JLabel("Usertype");
    private JLabel isManager = new JLabel("Is manager");

    private JTextField firstnameT = new JTextField(10);
    private JTextField lastnameT = new JTextField(10);
    private JTextField emailT = new JTextField(10);
    private JPasswordField passwordT = new JPasswordField(10);
    private JComboBox usertypeT = new JComboBox();
    private JCheckBox isManagerT = new JCheckBox();

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

    public JLabel getIsManager() {
        return isManager;
    }

    public void setIsManager(JLabel isManager) {
        this.isManager = isManager;
    }

    public JCheckBox getIsManagerT() {
        return isManagerT;
    }

    public void setIsManagerT(JCheckBox isManagerT) {
        this.isManagerT = isManagerT;
    }

    public StaffTabUsersStaffCreateTab(){
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, label);
        add(BorderLayout.CENTER,form);


        firstname.setLabelFor(firstnameT);
        form.add(firstname);
        form.add(firstnameT);

        form.add(lastname);
        form.add(lastnameT);

        form.add(email);
        form.add(emailT);

        form.add(password);
        form.add(passwordT);

        form.add(usertype);
        form.add(usertypeT);

        form.add(isManager);
        form.add(isManagerT);

        form.add(saveUser);
        form.add(clearForm);
    }
}
