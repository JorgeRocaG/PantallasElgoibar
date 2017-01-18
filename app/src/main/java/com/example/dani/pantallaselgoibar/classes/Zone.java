package com.example.dani.pantallaselgoibar.classes;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Dani on 18/01/2017.
 */

public class Zone {
    String name;
    ArrayList<Machine> machines;


    public Zone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWorkingMachines(){
        Random rand = new Random();
        return rand.nextInt(20);
    }
    public int getHalfWorkingMachines(){
        Random rand = new Random();
        return rand.nextInt(20);
    }
    public int getNotWorkingMachines(){
        Random rand = new Random();
        return rand.nextInt(20);
    }
}
