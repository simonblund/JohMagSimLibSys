package com.JohMagSim.Libr;

import com.JohMagSim.Libr.utils.*;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "Yould you like to run database migrations? Y/N" );
        Scanner inp = new Scanner(System.in);
        if(inp.nextLine().toLowerCase().equals("y")){
            DBInitiation.createTables();
        }


    }
}
