package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.*;
import com.JohMagSim.Libr.views.*;

import javax.swing.event.*;
import java.awt.*;

public class MenuBarPanelVC {
    private MenubarPanel mbp;

    public MenuBarPanelVC(MenubarPanel menubarPanel){
        mbp = menubarPanel;
    }
    public MenubarPanel getMbp(){
        initMbp();
        return mbp;
    }

    public void initMbp(){
        mbp.add(mbp.getM1());

        if(App.signedInUser == null){
            mbp.add(mbp.getM3());
            mbp.getM3().addMenuListener(showUserSignin);
        } else {
            mbp.remove(mbp.getM3());
            mbp.add(mbp.getM4());
            mbp.getM4().addMenuListener(signout);
        }

        if(App.signedInStaff != null){
            mbp.remove(mbp.getM3());
            mbp.getM5().addMenuListener(showStaffPanel);
            mbp.add(mbp.getM5());
            mbp.add(mbp.getM4());
            mbp.getM4().addMenuListener(signout);
            mbp.updateUI();
        }
        else{}

        mbp.getM1().addMenuListener(showHomePanel);


    }

    private MenuListener showHomePanel = new MenuListener() {
        public void menuSelected(MenuEvent e) {
            App.vc.showHomePanel();

        }
        public void menuDeselected(MenuEvent event){}
        public void menuCanceled(MenuEvent e){}
    };

    private MenuListener signout = new MenuListener() {
        public void menuSelected(MenuEvent e) {
            App.signedInStaff=null;
            App.signedInUser=null;

            mbp.remove(mbp.getM4());
            mbp.removeAll();
            initMbp();
            mbp.revalidate();
            mbp.updateUI();

            App.vc.showHomePanel();

        }
        public void menuDeselected(MenuEvent event){}
        public void menuCanceled(MenuEvent e){}
    };

    private MenuListener showUserSignin = new MenuListener() {
        public void menuSelected(MenuEvent e) {
            App.vc.showSigninUserPanel();

        }
        public void menuDeselected(MenuEvent event){}
        public void menuCanceled(MenuEvent e){}
    };

    private MenuListener showStaffPanel = new MenuListener() {
        public void menuSelected(MenuEvent e) {
            App.vc.showStaffPanel();

        }
        public void menuDeselected(MenuEvent event){}
        public void menuCanceled(MenuEvent e){}
    };
}
