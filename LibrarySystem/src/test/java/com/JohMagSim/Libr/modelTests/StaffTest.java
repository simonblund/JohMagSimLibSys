package com.JohMagSim.Libr.modelTests;

import com.JohMagSim.Libr.model.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StaffTest {
    private Staff staffmember;
    private Staff staffmemberfromdb;
    public Staff createStaff(){

        UserType ut = new UserType();
        ut.setId(21);
        ut.setDescription("Staff");
        ut.setBooksAtATime(5);

        staffmember = new Staff();
        staffmember.setFirstName("Personalett");
        staffmember.setLastName("Personalettsson");
        staffmember.setEmail("personalett@library.test");
        staffmember.setPasswordHash("123123");
        staffmember.setPasswordResetToken("123123");
        staffmember.setManager(false);
        staffmember.setUsertype(ut);

        return staffmember;
    }

    @Test
    public void testSaveStaff(){
        Staff test = createStaff();
        StaffDAO.saveStaff(test);
        staffmemberfromdb = StaffDAO.findStaffFromName(test.getFirstName(), test.getLastName()).get(0);
        assertEquals(test.getEmail(), staffmemberfromdb.getEmail()); // Tests email (user)
    }

    /**
     * Should use the above created selected staff from db user to run tests, wont work.. Uses static
     * parameters, bad I know, will fix.
     */
    @Test
    public void testGetStaffFromId(){
        System.out.println(1);
        Staff selectedfromid = StaffDAO.findStaffFromId(5);
        assertEquals(selectedfromid.getEmail(), "personalett@library.test");
        System.out.println(selectedfromid.isManagerint());
    }
}
