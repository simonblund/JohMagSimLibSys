package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.controller.*;
import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.views.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class StaffTabUsersStaffCreateTabVC {
    private StaffTabUsersStaffCreateTab cip;
    private ArrayList<UserType> userTypes = UserTypeRepository.getUserTypes();

    public StaffTabUsersStaffCreateTabVC(StaffTabUsersStaffCreateTab createUserTab){
        cip = createUserTab;
    }

    public StaffTabUsersStaffCreateTab getCip(){
        return cip;
    }

    public void initStaffTabUsersStaffCreateTab(){


        for(int i=0;i<userTypes.size(); i++){
            cip.getUsertypeT().addItem(userTypes.get(i).getDescription());
        }
        cip.getSaveUser().addActionListener(saveUser);
        cip.setVisible(true);
        cip.getClearForm().addActionListener(clearForm);
        cip.updateUI();
    }

    private ActionListener clearForm = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearFields();
        }
    };

    private ActionListener saveUser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstname = cip.getFirstnameT().getText();
            String lastname = cip.getLastnameT().getText();
            String email = cip.getEmailT().getText();
            String password = new String(cip.getPasswordT().getPassword());
            password = AuthControl.hashPassword(password);
            String passwordReset = AuthControl.getPasswordResetToken();
            int usertypeid = cip.getUsertypeT().getSelectedIndex();
            int booksAtATime = userTypes.get(usertypeid).getBooksAtATime();
            boolean isManager = cip.getIsManagerT().isSelected();


            Staff user = new Staff();
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(email);
            user.setPasswordHash(password);
            user.setPasswordResetToken(passwordReset);
            user.setUserTypeID(usertypeid);
            user.setBooksAtATime(booksAtATime);
            user.setManager(isManager);

            StaffDAO.saveStaff(user);

            cip.add(new JLabel("Staff "+firstname+" created."));

        }
    };
    private void clearFields(){
        cip.remove(cip.getForm());
        cip.add(cip.getForm());
        cip.getForm().setVisible(false);
        cip.getForm().setVisible(true);
        cip.updateUI();

    }
}
