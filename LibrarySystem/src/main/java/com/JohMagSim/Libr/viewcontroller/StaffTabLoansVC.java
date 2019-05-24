package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.views.*;

import java.awt.*;

public class StaffTabLoansVC {
    private StaffTabLoans sti;

    public StaffTabLoansVC(StaffTabLoans staffTabItems){
        sti = staffTabItems;
    }

    public StaffTabLoans getSti(){
        return sti;
    }

    public void initStaffTabLoansVC(){
        StaffTabLoansCreateTabVC stictvc = new StaffTabLoansCreateTabVC(new StaffTabLoansCreateTab());
        stictvc.initStaffTabLoansCreateTab();

        //StaffTabItemsEditTabVC stietvc = new StaffTabItemsEditTabVC(new StaffTabItemsEditTab());
        //stietvc.initStaffTabItemsEditTab();

        sti.getItemTabs().addTab("Create", stictvc.getCip());
        //sti.getItemTabs().addTab("Edit", stietvc.getStiet());

        sti.add(BorderLayout.CENTER,sti.getItemTabs());
        sti.setVisible(true);
        sti.updateUI();
    }
}
