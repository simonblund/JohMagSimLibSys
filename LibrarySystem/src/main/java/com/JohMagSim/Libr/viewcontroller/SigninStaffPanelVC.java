package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.*;
import com.JohMagSim.Libr.controller.*;
import com.JohMagSim.Libr.views.*;

import java.awt.*;
import java.awt.event.*;

public class SigninStaffPanelVC {

    private SigninStaffPanel ssp;

    public SigninStaffPanelVC(SigninStaffPanel signinStaffPanel){
        ssp = signinStaffPanel;
    }
    public SigninStaffPanel getSsp(){
        initSup();
        return ssp;
    }

    private void initSup(){
        ssp.getSignInButton().addActionListener(signInButtonPressed);
        ssp.getSignInUser().addActionListener(userSigninButtonPressed);
        ssp.updateUI();
    }


    private ActionListener signInButtonPressed = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = ssp.getEmailField().getText();
            char[] password = ssp.getPasswordField().getPassword();
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (AuthControl.checkEmailExists(email)) {
                        try{
                            System.out.println("here"+ password + email);

                            App.signedInStaff = AuthControl.staffSignIn(email, password);
                            App.vc.showStaffPanel();
                            App.vc.getMbpvc().initMbp();

                        }
                        catch (Exception b){
                            ssp.getEmailField().setBackground(Color.red);
                            ssp.getPasswordField().setBackground(Color.red);
                        }

                    } else{
                        ssp.getEmailField().setToolTipText("Email & Password no matchy matchy");
                        ssp.getPasswordField().setBackground(Color.red);
                        ssp.getPasswordField().setBackground(Color.red);
                    }

                }
            });
            thread.run();
            ssp.updateUI();
        }
    };

    private ActionListener userSigninButtonPressed = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            App.vc.showSigninUserPanel();
        }
    };
}
