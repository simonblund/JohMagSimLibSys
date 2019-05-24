package com.JohMagSim.Libr.views;

import javax.swing.*;
import java.awt.*;

public class StaffTabLoansCreateTab extends JComponent {
    private JPanel findUserPanel = new JPanel();

    private JLabel findUserEmail = new JLabel("Search for user by email");
    private JTextField findUserEmailT = new JTextField(10);
    private JButton searchUser = new JButton("Search");

    private JPanel loanform = new JPanel();
    private JLabel barcode = new JLabel("Barcode of copy");
    private JTextField barcodeT = new JTextField(10);
    private JButton addCopy = new JButton("Add to loan");
    private JButton finishLoan = new JButton("Finish Loan and print receipt");

    public JPanel getFindUserPanel() {
        return findUserPanel;
    }

    public void setFindUserPanel(JPanel findUserPanel) {
        this.findUserPanel = findUserPanel;
    }

    public JLabel getFindUserEmail() {
        return findUserEmail;
    }

    public void setFindUserEmail(JLabel findUserEmail) {
        this.findUserEmail = findUserEmail;
    }

    public JTextField getFindUserEmailT() {
        return findUserEmailT;
    }

    public void setFindUserEmailT(JTextField findUserEmailT) {
        this.findUserEmailT = findUserEmailT;
    }

    public JButton getSearchUser() {
        return searchUser;
    }

    public void setSearchUser(JButton searchUser) {
        this.searchUser = searchUser;
    }

    public JPanel getLoanform() {
        return loanform;
    }

    public void setLoanform(JPanel loanform) {
        this.loanform = loanform;
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

    public JButton getAddCopy() {
        return addCopy;
    }

    public void setAddCopy(JButton addCopy) {
        this.addCopy = addCopy;
    }

    public JButton getFinishLoan() {
        return finishLoan;
    }

    public void setFinishLoan(JButton finishLoan) {
        this.finishLoan = finishLoan;
    }

    public StaffTabLoansCreateTab(){
        setLayout(new BorderLayout());

        findUserPanel.add(findUserEmail);
        findUserPanel.add(findUserEmailT);
        findUserPanel.add(searchUser);

        loanform.add(barcode);
        loanform.add(barcodeT);
        loanform.add(addCopy);

        add(findUserPanel);
        loanform.add(finishLoan);
        findUserPanel.setVisible(true);
        loanform.setVisible(false);
        finishLoan.setVisible(false);

    }
}
