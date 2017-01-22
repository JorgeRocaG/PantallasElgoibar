package com.example.dani.pantallaselgoibar.classes;

import com.example.dani.pantallaselgoibar.manager.Utilities;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Dani on 18/01/2017.
 */

public class Zone {
    private String name;
    private Machine[] machines;


    public Zone(String name) {
        this.name = name;
        machines = Utilities.getMachines();
    }

    public String getName() {
        return name;
    }

    public int getWorkingMachines(){
        int i = 0;

        for (Machine machine:
             machines) {
            if(machine.getStatus() == Machine.STATUS_WORKING){
                i++;
            }
        }

        return i;
    }
    public int getHalfWorkingMachines(){
        int i = 0;

        for (Machine machine:
                machines) {
            if(machine.getStatus() == Machine.STATUS_HALF_WORKING){
                i++;
            }
        }

        return i;
    }
    public int getNotWorkingMachines(){
        int i = 0;

        for (Machine machine:
                machines) {
            if(machine.getStatus() == Machine.STATUS_NOT_WORKING){
                i++;
            }
        }

        return i;
    }
}
