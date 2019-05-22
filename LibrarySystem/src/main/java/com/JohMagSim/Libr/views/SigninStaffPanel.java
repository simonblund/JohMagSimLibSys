package com.JohMagSim.Libr.views;

import com.JohMagSim.Libr.utils.*;

import javax.swing.*;
import java.awt.*;

public class SigninStaffPanel extends JPanel {
    private JSplitPane splitPanel = new JSplitPane();
    private JPanel panelLeft = new JPanel();
    private JPanel panelRight = new JPanel();
    private GridBagConstraints gbc = new GridBagConstraints();
    private JLabel textLeft = new JLabel("Sign in staff");
    private JButton signInUser = new JButton("User sign in");
    private JLabel email = new JLabel("email");
    private JLabel password = new JLabel("Password");
    private JTextField emailField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton signInButton = new JButton("Sign in");

    public JSplitPane getSplitPanel() {
        return splitPanel;
    }

    public void setSplitPanel(JSplitPane splitPanel) {
        this.splitPanel = splitPanel;
    }

    public JPanel getPanelLeft() {
        return panelLeft;
    }

    public void setPanelLeft(JPanel panelLeft) {
        this.panelLeft = panelLeft;
    }

    public JPanel getPanelRight() {
        return panelRight;
    }

    public void setPanelRight(JPanel panelRight) {
        this.panelRight = panelRight;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    public JLabel getTextLeft() {
        return textLeft;
    }

    public void setTextLeft(JLabel textLeft) {
        this.textLeft = textLeft;
    }

    public JButton getSignInUser() {
        return signInUser;
    }

    public void setSignInUser(JButton signInUser) {
        this.signInUser = signInUser;
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

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getSignInButton() {
        return signInButton;
    }

    public void setSignInButton(JButton signInButton) {
        this.signInButton = signInButton;
    }



    public SigninStaffPanel(){
        setLayout(new BorderLayout());
        panelLeft.setLayout(new BorderLayout());
        panelLeft.setBackground(ViewProperties.primaryColor);
        panelLeft.setVisible(true);


        panelRight.setLayout(new GridBagLayout());


        panelRight.setBackground(ViewProperties.primaryColorLight);
        panelRight.setVisible(true);

        splitPanel.add(JSplitPane.LEFT, panelLeft);
        splitPanel.add(JSplitPane.RIGHT, panelRight);



        panelLeft.add(BorderLayout.CENTER,textLeft);
        panelLeft.add(BorderLayout.SOUTH, signInUser);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0.5;
        panelRight.add(email,gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0.5;
        gbc.insets=new Insets(10,0,0,0);
        panelRight.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0.5;
        panelRight.add(password,gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0.5;
        panelRight.add(passwordField,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.weightx = 0.5;
        panelRight.add(signInButton,gbc);

        add(BorderLayout.CENTER, splitPanel);
        setVisible(true);
        setBackground(ViewProperties.primaryColorLight);
    }

}
