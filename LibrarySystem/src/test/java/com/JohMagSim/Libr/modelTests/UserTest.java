package com.JohMagSim.Libr.modelTests;

import com.JohMagSim.Libr.model.*;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public static void UserTest(){
        User test = new User();
        test.setId(1);
        assertEquals(1,test.getId());
    }
}
