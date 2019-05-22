package com.JohMagSim.Libr.viewcontroller;


import com.JohMagSim.Libr.views.*;
import com.JohMagSim.Libr.views.Frame;

import javax.swing.*;
import java.awt.*;

public class ViewControl {
    public Frame frame;
    private JPanel center = new JPanel();
    private CardLayout cards = new CardLayout();
    public void init(){
        frame = new Frame("Libsys");
        center.setLayout(cards);
        HomePanelVC homePanelVC = new HomePanelVC(new HomePanel());
        frame.add(BorderLayout.NORTH,new MenuBarPanelVC(new MenubarPanel()).getMbp());
        center.add("home",homePanelVC.getHomepanel());
        frame.add(center, BorderLayout.CENTER);
        cards.show(center, "home");
        homePanelVC.initHomePanel();
    }

    public void showSigninUserPanel(){
        SigninUserPanel sup = new SigninUserPanelVC(new SigninUserPanel()).getSup();
        center.add("sup",sup);
        cards.show(center, "sup");
    }
    public void showSigninStaffPanel(){
        SigninStaffPanel ssp = new SigninStaffPanelVC(new SigninStaffPanel()).getSsp();
        center.add("ssp",ssp);
        cards.show(center, "ssp");
    }

}