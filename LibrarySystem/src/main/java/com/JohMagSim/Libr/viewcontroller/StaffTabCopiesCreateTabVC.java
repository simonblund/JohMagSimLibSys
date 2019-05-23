package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.views.*;

public class StaffTabCopiesCreateTabVC {
    private StaffTabCopiesCreateTab cip;

    public StaffTabCopiesCreateTabVC(StaffTabCopiesCreateTab createCopyTab){
        cip = createCopyTab;
    }

    public StaffTabCopiesCreateTab getCip(){
        return cip;
    }

    public void initStaffTabCopiesCreateTab(){
        cip.setVisible(true);
        cip.updateUI();
    }
}
