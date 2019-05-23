package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.views.*;

import java.awt.*;

public class StaffTabCopiesVC {
    private StaffTabCopies sti;

    public StaffTabCopiesVC(StaffTabCopies staffTabCopies){
        sti = staffTabCopies;
    }

    public StaffTabCopies getSti(){
        return sti;
    }

    public void initStaffTabCopies(){
        StaffTabCopiesCreateTabVC stcctvc = new StaffTabCopiesCreateTabVC(new StaffTabCopiesCreateTab());
        stcctvc.initStaffTabCopiesCreateTab();

        StaffTabCopiesEditTabVC stietvc = new StaffTabCopiesEditTabVC(new StaffTabCopiesEditTab());
        stietvc.initStaffTabCopiesEditTab();

        sti.getCopyTabs().addTab("Create", stcctvc.getCip());
        sti.getCopyTabs().addTab("Edit", stietvc.getStiet());

        sti.add(BorderLayout.CENTER,sti.getCopyTabs());
        sti.setVisible(true);
        sti.updateUI();
    }
}
