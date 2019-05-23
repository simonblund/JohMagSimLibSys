package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.controller.*;
import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.views.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class StaffTabUsersCreateTabVC {
    private StaffTabUsersCreateTab cip;

    public StaffTabUsersCreateTabVC(StaffTabUsersCreateTab createUserTab){
        cip = createUserTab;
    }

    public StaffTabUsersCreateTab getCip(){
        return cip;
    }

    public void initStaffTabUsersCreateTab(){

        UserTypeRepository.startup();

        ArrayList<UserType> userTypes = UserTypeRepository.getUserTypes();
        for(int i=0;i<userTypes.size(); i++){
            cip.getUsertypeT().addItem(userTypes.get(i).getDescription());
        }
        cip.getSaveUser().addActionListener(saveUser);
        cip.setVisible(true);
        cip.updateUI();
    }

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

            User user = new User();
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(email);
            user.setPasswordHash(password);
            user.setPasswordResetToken(passwordReset);
            user.setUserTypeID(usertypeid);

            UserDAO.saveUser(user);

            cip.add(new JLabel("User "+firstname+" created."));

        }
    };
}
