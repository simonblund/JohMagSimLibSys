package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.*;
import com.JohMagSim.Libr.controller.*;
import com.JohMagSim.Libr.views.*;

import java.awt.*;
import java.awt.event.*;

public class SigninUserPanelVC {
    private SigninUserPanel sup;

    public SigninUserPanelVC(SigninUserPanel signinUserPanel){
        sup = signinUserPanel;
    }
    public SigninUserPanel getSup(){
        initSup();
        return sup;
    }

    private void initSup(){
        sup.getSignInButton().addActionListener(signInButtonPressed);
        sup.getSignInStaff().addActionListener(signinStaffButtonPressed);
        sup.updateUI();
    }


    private ActionListener signInButtonPressed = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = sup.getEmailField().getText();
            char[] password = sup.getPasswordField().getPassword();
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (AuthControl.checkEmailExists(email)) {
                        try{
                            App.signedInUser = AuthControl.signIn(email, password);
                            App.vc.showHomePanel();
                            App.vc.getMbpvc().initMbp();

                        }
                        catch (Exception b){
                            sup.getEmailField().setBackground(Color.red);
                            sup.getPasswordField().setBackground(Color.red);
                        }

                    } else{
                        sup.getEmailField().setToolTipText("Email & Password no matchy matchy");
                        sup.getPasswordField().setBackground(Color.red);
                        sup.getPasswordField().setBackground(Color.red);
                    }

                }
            });
            thread.run();
            sup.updateUI();
        }
    };

    private ActionListener signinStaffButtonPressed = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            App.vc.showSigninStaffPanel();
        }
    };
}
