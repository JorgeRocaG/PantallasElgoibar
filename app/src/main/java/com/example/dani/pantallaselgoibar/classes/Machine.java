package com.example.dani.pantallaselgoibar.classes;

/**
 * Created by Dani on 18/01/2017.
 */

public class Machine {
    public static final int STATUS_WORKING = 0;
    public static final int STATUS_HALF_WORKING = 1;
    public static final int STATUS_NOT_WORKING = 2;

    private String name;
    private int status;

    public Machine(String name, int status){
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
