package com.JohMagSim.Libr.modelTests;

import com.JohMagSim.Libr.model.*;
import org.junit.*;

public class StaffTest {
    public Staff createStaff(){

        UserType ut = new UserType();
        ut.setId(21);
        ut.setDescription("Staff");
        ut.setBooksAtATime(5);

        Staff staff = new Staff();
        staff.setFirstName("Personalett");
        staff.setLastName("Personalettsson");
        staff.setEmail("personalett@library.test");
        staff.setPasswordHash("123123");
        staff.setPasswordResetToken("123123");
        staff.setManager(false);
        staff.setUsertype(ut);

        return staff;
    }

    @Test
    public void testSaveStaff(){
        Staff test = createStaff();
        StaffDAO.saveStaff(test);
    }
}
