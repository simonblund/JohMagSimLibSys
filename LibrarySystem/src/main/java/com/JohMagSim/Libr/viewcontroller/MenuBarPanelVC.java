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

        if(App.signedInUser == null){
            mbp.add(mbp.getM3());
            mbp.getM3().addMenuListener(menuListener);
        } else {
            mbp.remove(mbp.getM3());
            mbp.add(mbp.getM4());
        }
    }

    private MenuListener menuListener = new MenuListener() {
        public void menuSelected(MenuEvent e) {
            App.vc.showSigninUserPanel();

        }
        public void menuDeselected(MenuEvent event){}
        public void menuCanceled(MenuEvent e){}
    };
}
