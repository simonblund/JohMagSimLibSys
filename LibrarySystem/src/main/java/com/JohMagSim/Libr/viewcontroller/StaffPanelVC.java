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

        StaffTabUsersVC stuvc = new StaffTabUsersVC(new StaffTabUsers());
        stuvc.initStaffTabUsers();

        StaffTabLoansVC staffTabLoansVC = new StaffTabLoansVC(new StaffTabLoans());
        staffTabLoansVC.initStaffTabLoansVC();

        sp.getStaffTabs().addTab("Staff", sthvc.getSth());
        sp.getStaffTabs().addTab("Item", stivc.getSti());
        sp.getStaffTabs().addTab("Copies", stcvc.getSti());
        sp.getStaffTabs().addTab("Users", stuvc.getSti());
        sp.getStaffTabs().addTab("Loans", staffTabLoansVC.getSti());

        sp.add(BorderLayout.CENTER,sp.getStaffTabs());
        sp.setVisible(true);
        sp.updateUI();
    }
}
