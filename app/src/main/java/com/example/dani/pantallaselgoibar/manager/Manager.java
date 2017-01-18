package com.example.dani.pantallaselgoibar.manager;

import com.example.dani.pantallaselgoibar.classes.Zone;

import java.util.ArrayList;

/**
 * Created by Dani on 18/01/2017.
 */

public class Manager {
    Utilities utilities;

    public Manager() {
        utilities = new Utilities();
    }

    public ArrayList<Zone> getZones(){
        ArrayList<Zone> zones = new ArrayList<>();
        zones.add(new Zone("Conventional"));
        zones.add(new Zone("Manufacturing"));
        zones.add(new Zone("Didactics"));
        zones.add(new Zone("Facilities"));
        return zones;
    }
}
