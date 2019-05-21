package com.JohMagSim.Libr.model;

public class UserTypeRepository {
    private static UserType normalUser;
    private static UserType researchUser;

    public static void startup(){
        createNormalUserType();
        createResearcherUserType();
    }

    private static void createNormalUserType(){
        UserType ut = new UserType();
        ut.setId(1);
        ut.setDescription("Normal user");
        ut.setBooksAtATime(5);
        normalUser =ut;
    }

    private static void createResearcherUserType(){
        UserType ut = new UserType();
        ut.setId(2);
        ut.setDescription("Research user");
        ut.setBooksAtATime(10);
        researchUser = ut;
    }

    public static UserType findUsertype(int id){
        switch(id){
            case 1: return normalUser;
            case 2: return researchUser;
            default: return normalUser;
        }
    }


}
