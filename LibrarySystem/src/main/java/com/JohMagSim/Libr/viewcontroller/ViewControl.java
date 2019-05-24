package com.JohMagSim.Libr.viewcontroller;


import com.JohMagSim.Libr.views.*;
import com.JohMagSim.Libr.views.Frame;

import javax.swing.*;
import java.awt.*;

public class ViewControl {
    public Frame frame;
    private JPanel center = new JPanel();
    private CardLayout cards = new CardLayout();

    private MenuBarPanelVC mbpvc = new MenuBarPanelVC(new MenubarPanel());

    public MenuBarPanelVC getMbpvc() {
        return mbpvc;
    }

    public void setMbpvc(MenuBarPanelVC mbpvc) {
        this.mbpvc = mbpvc;
    }
    public void init(){
        frame = new Frame("Libsys");
        center.setLayout(cards);
        HomePanelVC homePanelVC = new HomePanelVC(new HomePanel());
        frame.add(BorderLayout.NORTH,mbpvc.getMbp());
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

  /*  public void showCreateItemPanel(){
        CreateItemPanel cip = new CreateItemVC(new CreateItemPanel()).getCip();
        center.add("cip", cip);
        cards.show(center,"cip");
    }*/

    public void showStaffPanel(){
        StaffPanelVC sp = new StaffPanelVC(new StaffPanel());
        sp.initStaffPanel();
        center.add("sp",sp.getSp());
        cards.show(center,"sp");
    }

    public void showHomePanel(){
        HomePanelVC sp = new HomePanelVC(new HomePanel());
        sp.initHomePanel();
        center.add("hp",sp.getHomepanel());
        cards.show(center,"hp");
    }

}
