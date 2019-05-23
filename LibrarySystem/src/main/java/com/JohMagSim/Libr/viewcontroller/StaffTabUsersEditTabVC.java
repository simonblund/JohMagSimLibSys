package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.views.*;

public class StaffTabUsersEditTabVC {
    private StaffTabUsersEditTab cip;

    public StaffTabUsersEditTabVC(StaffTabUsersEditTab editUser){
        cip = editUser;
    }

    public StaffTabUsersEditTab getCip(){
        return cip;
    }

    public void initStaffTabUsersEditTab(){
        cip.setVisible(true);
        cip.updateUI();
    }
}
