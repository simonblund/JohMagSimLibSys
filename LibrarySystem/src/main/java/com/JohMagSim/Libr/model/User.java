package com.JohMagSim.Libr.model;

public class User {

    // Variables
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private String passwordResetToken;
    private int userTypeID;
    private int booksAtATime;

    // Setters & Getters
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public int getUserTypeID() {
        return userTypeID;
    }

    public void setUserTypeID(int userTypeID) {
        this.userTypeID = userTypeID;
    }

    public int getBooksAtATime() {
        return booksAtATime;
    }

    public void setBooksAtATime(int booksAtATime) {
        this.booksAtATime = booksAtATime;
    }

    public UserType getUserType(){
        return UserTypeRepository.findUsertype(userTypeID);
    }

}
