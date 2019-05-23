package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.views.*;

import java.awt.*;

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

        StaffTabItemsVC stivc = new StaffTabItemsVC(new StaffTabItems());
        stivc.initStaffPanelItems();

        StaffTabCopiesVC stcvc = new StaffTabCopiesVC(new StaffTabCopies());
        stcvc.initStaffTabCopies();

        sp.getStaffTabs().addTab("Staff", sthvc.getSth());
        sp.getStaffTabs().addTab("Item", stivc.getSti());
        sp.getStaffTabs().addTab("Copies", stcvc.getSti());
        sp.add(BorderLayout.CENTER,sp.getStaffTabs());
        sp.setVisible(true);
        sp.updateUI();
    }
}
