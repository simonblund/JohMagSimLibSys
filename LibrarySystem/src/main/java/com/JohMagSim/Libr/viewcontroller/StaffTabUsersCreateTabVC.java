package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.views.*;

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
}
