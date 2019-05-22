package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.views.*;

public class StaffPanelVC {
    private StaffPanel sp;

    public StaffPanelVC(StaffPanel staffPanel){
        sp = staffPanel;
    }

    public StaffPanel getSp(){
        return sp;
    }

    public void initStaffPanel(){

        StaffTabHomeVC sthvc = new StaffTabHomeVC(new StaffTabHome());
        sthvc.initStaffPanel();
        sp.getStaffTabs().addTab("Staff", sthvc.getSth());
        sp.add(sp.getStaffTabs());
        sp.setVisible(true);
        sp.updateUI();
    }
}
