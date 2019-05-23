package com.JohMagSim.Libr;

import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.utils.*;
import com.JohMagSim.Libr.utils.log.*;
import com.JohMagSim.Libr.view.*;
import com.JohMagSim.Libr.viewcontroller.*;

import java.io.*;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static User signedInUser;
    public static ViewControl vc = new ViewControl();
    public static void main(String[] args) {
        // Set up logger OBS if DEV send string to LibraryLoggerSetup
        try {
            LibraryLogger.setup("dev");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }

        System.out.println("Library System is starting!");

        LoanTerminalFrame frame = new LoanTerminalFrame("Låneterminal");
        frame.setVisible(true);

        vc.init();

        // Ask if setuphelper should run
        Scanner inp = new Scanner(System.in);
        System.out.println("Would you like to run setuphelper? Y/N");
        if (inp.nextLine().toLowerCase().equals("y")) {
            SetupHelper.start();
        }


    }
}
