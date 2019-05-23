package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.views.*;

public class StaffTabCopiesEditTabVC {
    private StaffTabCopiesEditTab stcet;

    public StaffTabCopiesEditTabVC(StaffTabCopiesEditTab createItemPanel){
        stcet = createItemPanel;
    }

    public StaffTabCopiesEditTab getStiet(){
        return stcet;
    }

    public void initStaffTabCopiesEditTab(){
        stcet.setVisible(true);
        stcet.updateUI();
    }
}
