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

        StaffTabUsersStaffCreateTabVC stusctvc = new StaffTabUsersStaffCreateTabVC(new StaffTabUsersStaffCreateTab());
        stusctvc.initStaffTabUsersStaffCreateTab();

        StaffTabUsersStaffEditTabVC staffTabUsersStaffEditTabVC = new StaffTabUsersStaffEditTabVC(new StaffTabUsersStaffEditTab());
        staffTabUsersStaffEditTabVC.initStaffTabUsersStaffEditTab();

        sti.getUserTabs().addTab("Create", stcctvc.getCip());
        sti.getUserTabs().addTab("Edit", stuetvc.getCip());

        sti.getUserTabs().addTab("Create Staff", stusctvc.getCip());
        sti.getUserTabs().addTab("Edit Staff", staffTabUsersStaffEditTabVC.getCip());

        sti.add(BorderLayout.CENTER,sti.getUserTabs());
        sti.setVisible(true);
        sti.updateUI();
    }
}
