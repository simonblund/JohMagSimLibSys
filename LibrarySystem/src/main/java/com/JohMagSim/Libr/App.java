package com.JohMagSim.Libr;

import com.JohMagSim.Libr.utils.*;
import com.JohMagSim.Libr.utils.log.*;

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
        System.out.println( "Yould you like to run database migrations? Y/N" );
        Scanner inp = new Scanner(System.in);
        if(inp.nextLine().toLowerCase().equals("y")){
            DBInitiation.createTables();
        }



    }
}
