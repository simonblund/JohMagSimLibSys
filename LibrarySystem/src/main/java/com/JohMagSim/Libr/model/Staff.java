package com.JohMagSim.Libr.model;

public class Staff extends User {
    private int staffId;
    private boolean manager;

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public boolean isManager() {
        return manager;
    }

    public int isManagerint(){
        if(manager){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }
}
