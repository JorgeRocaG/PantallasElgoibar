package com.example.dani.pantallaselgoibar.manager;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.dani.pantallaselgoibar.R;
import com.example.dani.pantallaselgoibar.classes.Machine;
import com.example.dani.pantallaselgoibar.classes.Zone;
import com.example.dani.pantallaselgoibar.fragments.LoginFragment;
import com.example.dani.pantallaselgoibar.fragments.MachineStatusFragment;
import com.example.dani.pantallaselgoibar.fragments.SectionFragment;
import com.example.dani.pantallaselgoibar.fragments.SectionTotalFragment;

import java.util.ArrayList;

/**
 * Created by Dani on 21/01/2017.
 */

public class FrameManager {

    public static final int LOGIN = 0;
    public static final int MACHINE_ZONES = 1;
    public static final int MACHINE_STATUS = 10;
    public static final int WORK_ORDERS = 2;
    public static final int INSTRUCTIONS = 3;
    public static final int SETTINGS = 4;
    public static final int HELP = 5;
    private static final int ARG_SHOW_MACHINE_STATUS_MACHINES = 0;
    private static final int ARG_SHOW_MACHINE_STATUS_ZONE = 0;


    void switchMainFragment(AppCompatActivity activity, int fragmentTag, Object[] args) {
        switch (fragmentTag){
            case LOGIN:
                showLogin(activity, args);
                break;
            case MACHINE_ZONES:
                showMachineZones(activity, args);
                break;
            case MACHINE_STATUS:
                showMachineStatus(activity, args);
                break;
            case WORK_ORDERS:
                showWorkOrders(activity, args);
                break;
            case INSTRUCTIONS:
                showInstructions(activity, args);
                break;
            case SETTINGS:
                showSettings(activity, args);
                break;
            case HELP:
                showHelp(activity, args);
                break;
        }
    }

    void switchMainFragment(AppCompatActivity activity, int fragment) {
        switchMainFragment(activity,fragment,null);
    }


    private void showLogin(AppCompatActivity activity, Object[] args){
        FrameLayout frameLayout = this.getEmptyMainFrame(activity);
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        LoginFragment lf = LoginFragment.newInstance();

        ft.add(frameLayout.getId(),lf);
        ft.commit();

    }

    private void showMachineZones(AppCompatActivity activity, Object[] args){
        FrameLayout frameLayout = this.getEmptyMainFrame(activity);
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Manager m = Manager.getInstance();

        ArrayList<Zone> zones = m.getZones();
        ScrollView scrollView = new ScrollView(activity.getApplicationContext());

        scrollView.setId(View.generateViewId());
        LinearLayout linearScroll = new LinearLayout(activity.getApplicationContext());
        linearScroll.setId(R.id.layout);
        linearScroll.setOrientation(LinearLayout.VERTICAL);

        scrollView.addView(linearScroll);
        frameLayout.addView(scrollView);

        SectionTotalFragment stf = this.fillSectionFragment(zones);
        ft.add(linearScroll.getId(),stf);
        for (Zone zone: zones) {
            SectionFragment sf = SectionFragment.newInstance(
                    zone.getName(),
                    zone.getWorkingMachines(),
                    zone.getHalfWorkingMachines(),
                    zone.getNotWorkingMachines());
            ft.add(linearScroll.getId(),sf,zone.getName());
        }
        ft.commit();
    }

    //TODO: acabar este método
    private void showMachineStatus(AppCompatActivity activity, Object[] args) {
        FrameLayout frameLayout = this.getEmptyMainFrame(activity);
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Machine[] machines;
        //TODO: try/catch(nullPointerException)
        if (args[ARG_SHOW_MACHINE_STATUS_MACHINES] instanceof Machine[]) {
            machines = (Machine[]) args[ARG_SHOW_MACHINE_STATUS_MACHINES];
        }else{
            machines = Manager.getInstance().getMachines((String)args[ARG_SHOW_MACHINE_STATUS_ZONE]);
        }

        LinearLayout mainLayout = new LinearLayout(activity.getApplicationContext());
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        frameLayout.addView(mainLayout);


        ScrollView scrollView = new ScrollView(activity.getApplicationContext());
        scrollView.setId(View.generateViewId());
        int screenHeight = Utilities.getScreenParams(activity)[1];
        mainLayout.addView(scrollView, new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, screenHeight-Utilities.dipToPixel(activity, 125)));

        LinearLayout linearScroll = new LinearLayout(activity.getApplicationContext());
        linearScroll.setId(R.id.layout);
        linearScroll.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(linearScroll);

        for (Machine machine: machines){
            MachineStatusFragment msf = MachineStatusFragment.newInstance(machine.getName(),machine.getStatus());
            ft.add(linearScroll.getId(),msf,machine.getName());
        }



        LinearLayout filterLayout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.machine_filter,mainLayout,false);
        mainLayout.addView(filterLayout);

        ft.commit();

    }

    private void showWorkOrders(AppCompatActivity activity, Object[] args) {
        FrameLayout frameLayout = this.getEmptyMainFrame(activity);
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Manager m = Manager.getInstance();


        ft.commit();
    }

    private void showInstructions(AppCompatActivity activity, Object[] args) {
        FrameLayout frameLayout = this.getEmptyMainFrame(activity);
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Manager m = Manager.getInstance();

        ft.commit();
    }

    private void showSettings(AppCompatActivity activity, Object[] args) {
        FrameLayout frameLayout = this.getEmptyMainFrame(activity);
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Manager m = Manager.getInstance();

        ft.commit();
    }

    private void showHelp(AppCompatActivity activity, Object[] args) {
        FrameLayout frameLayout = this.getEmptyMainFrame(activity);
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Manager m = Manager.getInstance();

        ft.commit();
    }


    private SectionTotalFragment fillSectionFragment(ArrayList<Zone> zones) {
        SectionTotalFragment stf;
        int working = 0;
        int halfWorking = 0;
        int notWorking = 0;
        float total;
        int percent;
        for (Zone zone : zones) {
            working += zone.getWorkingMachines();
            halfWorking += zone.getHalfWorkingMachines();
            notWorking += zone.getNotWorkingMachines();
        }
        total = working + halfWorking + notWorking;
        percent = ((int) ((working + halfWorking) / total * 100));

        stf = SectionTotalFragment.newInstance(
                working,
                halfWorking,
                notWorking,
                percent
        );

        return stf;
    }

    private FrameLayout getEmptyMainFrame(AppCompatActivity activity){
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content_navigation);
        frameLayout.removeAllViews();
        return frameLayout;
    }
}
