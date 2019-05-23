package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.views.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StaffTabUsersEditTabVC {
    private StaffTabUsersEditTab cip;
    private User loadedUser;
    private ArrayList<UserType> userTypes = UserTypeRepository.getUserTypes();

    public StaffTabUsersEditTabVC(StaffTabUsersEditTab editUser){
        cip = editUser;
    }

    public StaffTabUsersEditTab getCip(){
        return cip;
    }

    public void initStaffTabUsersEditTab(){
        cip.getSearchButton().addActionListener(searchUser);


        cip.getSearchuser().setVisible(true);
        cip.getSearchButton().setVisible(true);

        cip.setVisible(true);
        cip.updateUI();
    }

    private ActionListener searchUser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = cip.getSearchuser().getText();
            try {
                User user = UserDAO.findUserFromEmail(email);
                loadedUser = user;
                editUser(user);


            } catch (Exception a){
                System.out.println(a.getMessage());
            }

        }
    };

    private void editUser(User user){


        for(int i=0;i<userTypes.size(); i++){
            cip.getUsertypeT().addItem(userTypes.get(i).getDescription());
        }

        cip.getFirstnameT().setText(user.getFirstName());
        cip.getLastnameT().setText(user.getLastName());
        cip.getEmailT().setText(user.getEmail());
        cip.getUsertypeT().setSelectedIndex(user.getUserTypeID());
        cip.remove(cip.getSearchForm());
        cip.add(BorderLayout.CENTER,cip.getForm());
        cip.getSaveUser().addActionListener(saveUser);
        cip.getForm().setVisible(true);
        cip.updateUI();

    }

    private ActionListener saveUser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            User user = loadedUser;

            String firstname = cip.getFirstnameT().getText();
            String lastname = cip.getLastnameT().getText();
            String email = cip.getEmailT().getText();
            int usertypeid = cip.getUsertypeT().getSelectedIndex();
            int booksAtATime = userTypes.get(usertypeid).getBooksAtATime();

            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(email);
            user.setUserTypeID(usertypeid);
            user.setBooksAtATime(booksAtATime);

            UserDAO.updateUser(user);

        }
    };
}
