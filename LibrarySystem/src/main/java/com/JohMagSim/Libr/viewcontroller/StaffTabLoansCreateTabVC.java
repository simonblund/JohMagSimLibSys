package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.views.*;

import javax.swing.*;
import java.awt.event.*;
import java.time.*;
import java.util.*;

public class StaffTabLoansCreateTabVC {
    private StaffTabLoansCreateTab cip;
    private User loadedUser;
    private ArrayList<UserType> userTypes = UserTypeRepository.getUserTypes();

    public StaffTabLoansCreateTabVC(StaffTabLoansCreateTab createUserTab){
        cip = createUserTab;
    }

    public StaffTabLoansCreateTab getCip(){
        return cip;
    }

    public void initStaffTabLoansCreateTab(){
        cip.getSearchUser().addActionListener(findUser);
        cip.getAddCopy().addActionListener(createLoan);
        cip.add(cip.getFindUserPanel());
        cip.getFindUserPanel().setVisible(true);
        cip.getFinishLoan().addActionListener(saveLoan);

        cip.setVisible(true);
        cip.updateUI();
    }

    private ActionListener findUser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = cip.getFindUserEmailT().getText();
            try{
                loadedUser = UserDAO.findUserFromEmail(email);
                cip.getFindUserPanel().setVisible(false);
                cip.add(cip.getLoanform());
                cip.getLoanform().setVisible(true);
                cip.updateUI();
            }catch (Exception a){
                cip.add(new JLabel("An error occured: "+a.getMessage()));
            }

        }
    };

    private ActionListener createLoan = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String barcode = cip.getBarcodeT().getText();
            Copy copy = CopyDAO.findCopybyBarcode(barcode);
            Item item = ItemDAO.findItembyId(copy.getItemID());


            Loan loan = new Loan();
            loan.setCopyID(copy.getId());
            loan.setDate(LocalDate.now());
            loan.setExpectedReturnDate(LocalDate.now().plusDays(item.getLoantime()));
            loan.setUserID(loadedUser.getId());

            LoanDAO.insertLoan(loan);


            cip.getBarcodeT().setText("");
            cip.getLoanform().add(new JLabel("Loan added: "+item.getTitle()));
            cip.getFinishLoan().setVisible(true);
        }
    };

    private ActionListener saveLoan = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList loans = LoanDAO.findActiveLoansFromUserID(loadedUser.getId());
            new ReceiptFrame(loans, loadedUser);
            loadedUser = null;
            cip.getLoanform().setVisible(false);
            cip.getFindUserPanel().setVisible(true);
            cip.getFindUserEmailT().setText("");

        }
    };
}
