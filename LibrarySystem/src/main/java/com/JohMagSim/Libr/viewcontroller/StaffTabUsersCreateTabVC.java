package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.views.*;

import java.awt.event.*;

public class StaffTabUsersCreateTabVC {
    private StaffTabUsersCreateTab cip;

    public StaffTabUsersCreateTabVC(StaffTabUsersCreateTab createUserTab){
        cip = createUserTab;
    }

    public StaffTabUsersCreateTab getCip(){
        return cip;
    }

    public void initStaffTabUsersCreateTab(){
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
            int usertypeid = cip.getUsertypeT().getSelectedIndex();

            // Här bryter jag för middag.

        }
    };
}
