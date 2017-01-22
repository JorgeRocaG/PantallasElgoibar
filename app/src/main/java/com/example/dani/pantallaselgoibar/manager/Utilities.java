package com.example.dani.pantallaselgoibar.manager;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.example.dani.pantallaselgoibar.classes.Machine;
import com.example.dani.pantallaselgoibar.classes.Zone;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Dani on 18/01/2017.
 */

public class Utilities {
    public static ArrayList<Zone> getZones() {
        ArrayList<Zone> zones = new ArrayList<>();
        zones.add(new Zone("Conventional"));
        zones.add(new Zone("Manufacturing"));
        zones.add(new Zone("Didactics"));
        zones.add(new Zone("Facilities"));
        return zones;
    }
    public static int dipToPixel(Activity activity,int dip){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return (int) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, dip, displaymetrics );
    }
    public static int[] getScreenParams(Activity activity){
        int[] screen = new int[2];
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screen[0] = displaymetrics.widthPixels;
        screen[1] = displaymetrics.heightPixels;
        return screen;
    }

    public static Machine[] getMachines(){
        Random rand = new Random();
        Machine[] machines = new Machine[20];
        for (int i = 0 ; i < machines.length; i++){
            machines[i] = new Machine("CF-"+i,rand.nextInt(3));
        }
        return machines;
    }
}
