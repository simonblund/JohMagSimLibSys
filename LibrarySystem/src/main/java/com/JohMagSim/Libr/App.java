package com.JohMagSim.Libr;

import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.utils.*;
import com.JohMagSim.Libr.utils.log.*;
import com.JohMagSim.Libr.viewcontroller.*;

import java.io.*;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static User signedInUser;
    public static Staff signedInStaff;
    public static ViewControl vc = new ViewControl();

    public static void main(String[] args) {
        // Set up logger OBS if DEV send string to LibraryLoggerSetup
        try {
            LibraryLogger.setup("dev");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
        UserTypeRepository.startup();

        System.out.println("Library System is starting!");

        vc.init();

        // Ask if setuphelper should run
        Scanner inp = new Scanner(System.in);
        System.out.println("Would you like to run setuphelper? Y/N");
        if (inp.nextLine().toLowerCase().equals("y")) {
            SetupHelper.start();
        }


    }
}
