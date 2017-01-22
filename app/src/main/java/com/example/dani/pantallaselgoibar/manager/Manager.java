package com.example.dani.pantallaselgoibar.manager;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.dani.pantallaselgoibar.classes.Machine;
import com.example.dani.pantallaselgoibar.classes.Zone;

import java.util.ArrayList;

/**
 * Created by Dani on 18/01/2017.
 */

public class Manager {
    private FrameManager frameManager;
    private static Manager manager = new Manager();
    private Manager() {
        frameManager = new FrameManager();
    }

    public static Manager getInstance(){
        return manager;
    }

    public ArrayList<Zone> getZones(){
        return  Utilities.getZones();
    }

    public void switchMainFragment(AppCompatActivity activity, int fragmentTag, Object[] args){
        frameManager.switchMainFragment(activity, fragmentTag, args);
    }
    public void switchMainFragment(AppCompatActivity activity, int fragmentTag){
        this.switchMainFragment(activity, fragmentTag, null);
    }
    public Machine[] getMachines(String zone) {
        Machine[] machines = Utilities.getMachines();

        return machines;
    }
}
