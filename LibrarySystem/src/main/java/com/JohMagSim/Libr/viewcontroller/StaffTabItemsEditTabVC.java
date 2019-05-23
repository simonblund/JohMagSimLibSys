package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.views.*;

public class StaffTabItemsEditTabVC {
    private StaffTabItemsEditTab stiet;

    public StaffTabItemsEditTabVC(StaffTabItemsEditTab createItemPanel){
        stiet = createItemPanel;
    }

    public StaffTabItemsEditTab getStiet(){
        return stiet;
    }

    public void initStaffTabItemsEditTab(){
        stiet.setVisible(true);
        stiet.updateUI();
    }
}
