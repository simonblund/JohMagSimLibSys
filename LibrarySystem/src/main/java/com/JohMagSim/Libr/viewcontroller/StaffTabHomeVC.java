package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.views.*;

public class StaffTabHomeVC {
    private StaffTabHome sth;

    public StaffTabHomeVC(StaffTabHome staffTabHome){
        sth = staffTabHome;
    }

    public StaffTabHome getSth(){
        return sth;
    }

    public void initStaffPanel(){
        //sp.add(sp.getStaffTabs());
        sth.setVisible(true);
        sth.updateUI();
    }

}
