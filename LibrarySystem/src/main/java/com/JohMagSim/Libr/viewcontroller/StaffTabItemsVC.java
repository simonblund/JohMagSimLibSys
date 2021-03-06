package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.views.*;

import java.awt.*;

public class StaffTabItemsVC {
    private StaffTabItems sti;

    public StaffTabItemsVC(StaffTabItems staffTabItems){
        sti = staffTabItems;
    }

    public StaffTabItems getSti(){
        return sti;
    }

    public void initStaffPanelItems(){
        StaffTabItemsCreateTabVC stictvc = new StaffTabItemsCreateTabVC(new StaffTabItemsCreateTab());
        stictvc.initStaffTabItemsCreateTab();

        StaffTabItemsEditTabVC stietvc = new StaffTabItemsEditTabVC(new StaffTabItemsEditTab());
        stietvc.initStaffTabItemsEditTab();

        sti.getItemTabs().addTab("Create", stictvc.getCip());
        sti.getItemTabs().addTab("Edit", stietvc.getStiet());

        sti.add(BorderLayout.CENTER,sti.getItemTabs());
        sti.setVisible(true);
        sti.updateUI();
    }
}
