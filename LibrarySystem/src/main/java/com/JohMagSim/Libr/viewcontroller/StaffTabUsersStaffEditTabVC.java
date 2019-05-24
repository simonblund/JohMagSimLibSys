package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.views.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StaffTabUsersStaffEditTabVC {
    private StaffTabUsersStaffEditTab cip;
    private Staff loadedUser;
    private ArrayList<UserType> userTypes = UserTypeRepository.getUserTypes();

    public StaffTabUsersStaffEditTabVC(StaffTabUsersStaffEditTab editUser){
        cip = editUser;
    }

    public StaffTabUsersStaffEditTab getCip(){
        return cip;
    }

    public void initStaffTabUsersStaffEditTab(){
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
                Staff user = StaffDAO.findStaffFromEmail(email);
                loadedUser = user;
                editUser(user);

            } catch (Exception a){
                System.out.println(a.getMessage());
            }

        }
    };

    private void editUser(Staff user){


        for(int i=0;i<userTypes.size(); i++){
            cip.getUsertypeT().addItem(userTypes.get(i).getDescription());
        }

        cip.getFirstnameT().setText(user.getFirstName());
        cip.getLastnameT().setText(user.getLastName());
        cip.getEmailT().setText(user.getEmail());
        cip.getUsertypeT().setSelectedIndex(user.getUserTypeID());
        cip.getIsManagerT().setSelected(user.isManager());
        cip.remove(cip.getSearchForm());
        cip.add(BorderLayout.CENTER,cip.getForm());
        cip.getSaveUser().addActionListener(saveUser);
        cip.getClearForm().addActionListener(clearForm);
        cip.getForm().setVisible(true);
        cip.updateUI();

    }

    private ActionListener clearForm = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearFields();
        }
    };

    private ActionListener saveUser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Staff user = loadedUser;

            String firstname = cip.getFirstnameT().getText();
            String lastname = cip.getLastnameT().getText();
            String email = cip.getEmailT().getText();
            int usertypeid = cip.getUsertypeT().getSelectedIndex();
            int booksAtATime = userTypes.get(usertypeid).getBooksAtATime();
            boolean isManager = cip.getIsManagerT().isSelected();

            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(email);
            user.setUserTypeID(usertypeid);
            user.setBooksAtATime(booksAtATime);
            user.setManager(isManager);

            StaffDAO.updateUser(user);

            clearFields();

        }
    };

    private void clearFields(){
        cip.remove(cip.getSearchForm());
        cip.add(cip.getSearchForm());
        loadedUser = null;
        cip.getForm().setVisible(false);
        cip.getSearchForm().setVisible(true);
        cip.updateUI();

    }
}
