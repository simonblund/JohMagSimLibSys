package com.JohMagSim.Libr.controller;

import at.favre.lib.crypto.bcrypt.*;
import com.JohMagSim.Libr.model.*;
import org.jasypt.util.password.*;

import java.util.*;
import java.util.logging.*;

public class AuthControl {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

    /**
     * Signin function returns a user object.
     * @param email String email is the user's email address.
     * @param passwordInput String Password
     * @return Signed in user.
     */

    //@TODO Should insert exception handling.
    public static User signIn(String email, char[] passwordInput)throws Exception{
        User user = UserDAO.findUserFromEmail(email);
        String passString = new String(passwordInput);
        if(passwordEncryptor.checkPassword(passString, user.getPasswordHash())){
            return user;
        } else{
            user = null;
            System.gc();
            LOGGER.info("User password did not match.");
            throw new Exception("User password did not match");
        }

    }

    public static boolean checkEmailExists(String email){
        User user = null;
        try{
            user= UserDAO.findUserFromEmail(email);
            if(user.getEmail().equals(email)){
                return true;
            }
            else {return false;}
        } catch (Exception e){
            return false;
        }
    }

    public static String hashPassword(String validatedPassword){
        return passwordEncryptor.encryptPassword(validatedPassword);
    }

    public static String getPasswordResetToken(){
        int length = 10;
        String symbol = "-/.^&*_!@%=+>)";
        String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_letter = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";


        String resetstring = cap_letter + small_letter +
                numbers + symbol;

        Random random = new Random();

        char[] password = new char[length];

        for (int i = 0; i < length; i++)
        {
            password[i] =
                    resetstring.charAt(random.nextInt(resetstring.length()));

        }
        System.out.println(password);
        return passwordEncryptor.encryptPassword(password.toString());

    }
}
