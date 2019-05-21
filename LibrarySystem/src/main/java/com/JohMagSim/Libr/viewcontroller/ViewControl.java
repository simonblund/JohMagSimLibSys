package com.JohMagSim.Libr.viewcontroller;


import com.JohMagSim.Libr.views.*;
import com.JohMagSim.Libr.views.Frame;

import javax.swing.*;
import java.awt.*;

public class ViewControl {
    public Frame frame;
    public void init(){
        frame = new Frame("Libsys");
        HomePanelVC homePanelVC = new HomePanelVC(new HomePanel());
        frame.add(BorderLayout.NORTH,new MenuBarPanelVC(new MenubarPanel()).getMbp());

        frame.add(BorderLayout.CENTER,homePanelVC.getHomepanel());
        homePanelVC.initHomePanel();
    }

    public void showSigninUserPanel(){
        frame.add(BorderLayout.CENTER, new SigninUserPanelVC(new SigninUserPanel()).getSup());
    }

}
