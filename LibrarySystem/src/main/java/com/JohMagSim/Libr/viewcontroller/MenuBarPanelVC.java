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

    private void initMbp(){
        mbp.getM3().addMenuListener(menuListener);
    }

    private MenuListener menuListener = new MenuListener() {
        public void menuSelected(MenuEvent e) {
            App.vc.showSigninUserPanel();

        }
        public void menuDeselected(MenuEvent event){}
        public void menuCanceled(MenuEvent e){}
    };
}
