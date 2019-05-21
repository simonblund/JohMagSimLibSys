package com.JohMagSim.Libr.utils;


import com.JohMagSim.Libr.controller.*;
import com.JohMagSim.Libr.model.*;

import java.util.*;

public class SetupHelper {
    public static void start(){
        System.out.println("It is the first time you are running this program.");
        System.out.println("Run this program to create the database file and admin account.");

        System.out.println("Let's start with the database file, would you like to create one now? Y/N");
        Scanner inp = new Scanner(System.in);
        if (inp.nextLine().toLowerCase().equals("y")) {
            runMigrations();
        }

        System.out.println("Moving on to the admin account, would you like to create one? Y/N");
        if (inp.nextLine().toLowerCase().equals("y")) {
            createAdmin();
        }
    }

    private static void runMigrations(){
        DBInitiation.createTables();
        System.out.println("Database CREATED");
    }

    private static void createAdmin(){
        Scanner inp = new Scanner(System.in);
        Staff staff = new Staff();
        System.out.println("Great let's begin:");
        System.out.println("Your firstname");
        staff.setFirstName(inp.nextLine());
        System.out.println("Your surname");
        staff.setLastName(inp.nextLine());
        System.out.println("Your email address");
        staff.setEmail(inp.nextLine());
        staff.setPasswordHash(AuthControl.hashPassword(setPassword(inp)));
        staff.setManager(true);
        staff.setUserTypeID(1);
        staff.setPasswordResetToken(AuthControl.getPasswordResetToken());

        StaffDAO.saveStaff(staff);
        System.out.println("User created");

    }
    private static String setPassword(Scanner inp){
        System.out.println("The password you wish to use");
        String password = null;
        password =inp.nextLine();
        System.out.println("Write the password again");
        if(password.equals(inp.nextLine())){
            return password;
        } else{
            setPassword(inp);
        }
        return password;

    }
}
