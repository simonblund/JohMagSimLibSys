package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.views.*;

import java.awt.*;

public class StaffTabUsersVC {
    private StaffTabUsers sti;

    public StaffTabUsersVC(StaffTabUsers staffTabUsers){
        sti = staffTabUsers;
    }

    public StaffTabUsers getSti(){
        return sti;
    }

    public void initStaffTabUsers(){
        StaffTabUsersCreateTabVC stcctvc = new StaffTabUsersCreateTabVC(new StaffTabUsersCreateTab());
        stcctvc.initStaffTabUsersCreateTab();

        StaffTabUsersEditTabVC stuetvc = new StaffTabUsersEditTabVC(new StaffTabUsersEditTab());
        stuetvc.initStaffTabUsersEditTab();

        sti.getUserTabs().addTab("Create", stcctvc.getCip());
        sti.getUserTabs().addTab("Edit", stuetvc.getCip());

        sti.add(BorderLayout.CENTER,sti.getUserTabs());
        sti.setVisible(true);
        sti.updateUI();
    }
}
