package com.JohMagSim.Libr;

import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.utils.*;
import com.JohMagSim.Libr.utils.log.*;
import com.JohMagSim.Libr.view.*;

import java.io.*;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Set up logger OBS if DEV send string to LibraryLoggerSetup
        try {
            LibraryLogger.setup("dev");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }


        System.out.println( "Hello World!" );


        // Ask if SQL migrations should run.
        System.out.println( "Would you like to run database migrations? Y/N" );
        Scanner inp = new Scanner(System.in);
        if(inp.nextLine().toLowerCase().equals("y")){
            DBInitiation.createTables();
        }

        //Ask if you want to show all active loans
        System.out.println( "Would you like to show all active loans? Y/N" );
        if(inp.nextLine().toLowerCase().equals("y")){
            ArrayList loanresult = LoanDAO.findAllActiveLoans();

            for (Object loanElement : loanresult) {
                System.out.println(loanElement);
            }
        }

        StaffLogin staffLogin = new StaffLogin();
        staffLogin.setup();
        staffLogin.setVisible(true);

        // Ask if test of db connection  should run.
        System.out.println( "Would you like to show users? Y/N" );
        if(inp.nextLine().toLowerCase().equals("y")){
            ArrayList<User> users = UserDAO.findUsersFromName("Simon", "Blomsterlund");
            System.out.println(users.size());
            System.out.println(users.get(0).getFirstName() + " " + users.get(0).getFirstName() );
        }



    }
}
