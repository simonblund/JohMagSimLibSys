package com.JohMagSim.Libr.model;

import java.util.*;

public class UserTypeRepository {
    private static UserType normalUser;
    private static UserType researchUser;

    private static ArrayList<UserType> userTypes = new ArrayList();

    public static ArrayList getUserTypes() {
        return userTypes;
    }

    public static void setUserTypes(ArrayList userTypes) {
        UserTypeRepository.userTypes = userTypes;
    }

    public static UserType getNormalUser() {
        return normalUser;
    }

    public static void setNormalUser(UserType normalUser) {
        UserTypeRepository.normalUser = normalUser;
    }

    public static UserType getResearchUser() {
        return researchUser;
    }

    public static void setResearchUser(UserType researchUser) {
        UserTypeRepository.researchUser = researchUser;
    }

    public static void startup(){
        createNormalUserType();
        createResearcherUserType();
    }

    private static void createNormalUserType(){
        UserType ut = new UserType();
        ut.setId(0);
        ut.setDescription("Normal user");
        ut.setBooksAtATime(5);
        normalUser =ut;
        userTypes.add(normalUser);
    }

    private static void createResearcherUserType(){
        UserType ut = new UserType();
        ut.setId(1);
        ut.setDescription("Research user");
        ut.setBooksAtATime(10);
        researchUser = ut;
        userTypes.add(researchUser);
    }

    public static UserType findUsertype(int id){
        switch(id){
            case 1: return normalUser;
            case 2: return researchUser;
            default: return normalUser;
        }
    }


}
