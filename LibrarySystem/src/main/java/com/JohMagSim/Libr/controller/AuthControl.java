package com.JohMagSim.Libr.controller;

import at.favre.lib.crypto.bcrypt.*;
import com.JohMagSim.Libr.model.*;

import java.util.logging.*;

public class AuthControl {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Signin function returns a user object.
     * @param email String email is the user's email address.
     * @param passwordInput String Password
     * @return Signed in user.
     */

    //@TODO Should insert exception handling.
    public static User signIn(String email, String passwordInput){
        User user = UserDAO.findUserFromEmail(email);
        String BCryptHashString = BCrypt.withDefaults().hashToString(12, passwordInput.toCharArray());
        if(BCrypt.verifyer().verify(user.getPasswordHash().toCharArray(), BCryptHashString).verified){
            return user;
        } else{
            user = null;
            LOGGER.info("User password did not match.");
            return user;
        }
    }
}
