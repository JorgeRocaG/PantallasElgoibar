package com.example.dani.pantallaselgoibar.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dani.pantallaselgoibar.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SectionTotalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionTotalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String WORKING = "working";
    private static final String HALF_WORKING = "half working";
    private static final String NOT_WORKING = "not working";
    private static final String PERCENT = "percent";

    // TODO: Rename and change types of parameters
    private int working;
    private int halfWorking;
    private int notWorking;
    private int percent;

    private OnFragmentInteractionListener mListener;

    public SectionTotalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SectionTotalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SectionTotalFragment newInstance(int working, int halfWorking, int notWorking, int percent) {
        SectionTotalFragment fragment = new SectionTotalFragment();
        Bundle args = new Bundle();
        args.putInt(WORKING, working);
        args.putInt(HALF_WORKING, halfWorking);
        args.putInt(NOT_WORKING, notWorking);
        args.putInt(NOT_WORKING, notWorking);
        args.putInt(PERCENT, percent);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            working = getArguments().getInt(WORKING);
            halfWorking = getArguments().getInt(HALF_WORKING);
            notWorking = getArguments().getInt(NOT_WORKING);
            percent = getArguments().getInt(PERCENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CardView cv = (CardView) inflater.inflate(R.layout.card_work_zone_total, container, false);
        ConstraintLayout cl = (ConstraintLayout)cv.findViewById(R.id.layout);
        TextView tvWorking = (TextView) cl.findViewById(R.id.tv_working);
        TextView tvHalfWorking = (TextView) cl.findViewById(R.id.tv_half_working);
        TextView tvNotWorking = (TextView) cl.findViewById(R.id.tv_not_working);
        TextView tvPercent = (TextView) cl.findViewById(R.id.tv_percent);

        tvWorking.setText(String.valueOf(working));
        tvHalfWorking.setText(String.valueOf(halfWorking));
        tvNotWorking.setText(String.valueOf(notWorking));
        tvPercent.setText(getString(R.string.percent,percent));

        int color;
        if(percent > 95){
            color = ResourcesCompat.getColor(getResources(),android.R.color.holo_green_light,null);
        }else if(percent > 90){
            color = ResourcesCompat.getColor(getResources(),android.R.color.holo_orange_light,null);
        }else{
            color = ResourcesCompat.getColor(getResources(),android.R.color.holo_red_light,null);
        }
        tvPercent.setTextColor(color);

        return cv;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
           // mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
