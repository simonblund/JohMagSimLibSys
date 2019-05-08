package com.JohMagSim.Libr.modelTests;

import com.JohMagSim.Libr.model.*;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class UserTest {

    /**
     * Creates a fake user obs no usertype.
     * @return User
     */

    public User testUser(){
        User user = new User();
        user.setEmail("test@test.ru");
        user.setFirstName("Elvan");
        user.setLastName("Elvansson");
        user.setPasswordHash("123123");
        user.setPasswordResetToken("123123123");
        return user;
    }

    @Test
    public void userSaveTest(){
        User test = testUser();
        UserDAO.saveUser(test);

        //User dbuser = UserDAO.findUsersFromName(test.getFirstName(), test.getLastName()).get(0);
        //assertEquals(test.getFirstName(), dbuser.getFirstName());
    }


}
