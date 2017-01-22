package com.example.dani.pantallaselgoibar.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dani.pantallaselgoibar.R;
import com.example.dani.pantallaselgoibar.manager.Manager;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionFragment extends Fragment implements CardView.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String NAME = "name";
    private static final String WORKING = "working";
    private static final String HALF_WORKING = "half working";
    private static final String NOT_WORKING = "not working";

    // TODO: Rename and change types of parameters
    private String name;
    private int working;
    private int halfWorking;
    private int notWorking;
    private String targetMachine;
    private OnFragmentInteractionListener mListener;

    public SectionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment SectionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SectionFragment newInstance(String name, int working, int halfWorking, int notWorking) {
        SectionFragment fragment = new SectionFragment();
        Bundle args = new Bundle();
        args.putString(NAME, name);
        args.putInt(WORKING, working);
        args.putInt(HALF_WORKING, halfWorking);
        args.putInt(NOT_WORKING, notWorking);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(NAME);
            working = getArguments().getInt(WORKING);
            halfWorking = getArguments().getInt(HALF_WORKING);
            notWorking = getArguments().getInt(NOT_WORKING);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        CardView cv = (CardView) inflater.inflate(R.layout.card_work_zone, container, false);
        ConstraintLayout cl = (ConstraintLayout)cv.findViewById(R.id.layout);
        TextView tvZone = (TextView) cl.findViewById(R.id.tv_work_zone);
        TextView tvWorking = (TextView) cl.findViewById(R.id.tv_working);
        TextView tvHalfWorking = (TextView) cl.findViewById(R.id.tv_half_working);
        TextView tvNotWorking = (TextView) cl.findViewById(R.id.tv_not_working);
        tvZone.setText(name);
        tvWorking.setText(String.valueOf(working));
        tvHalfWorking.setText(String.valueOf(halfWorking));
        tvNotWorking.setText(String.valueOf(notWorking));
        cv.setOnClickListener(this);
        return cv;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            //mListener.onFragmentInteraction(uri);
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

    @Override
    public void onClick(View view) {
        if(view instanceof CardView){
            ConstraintLayout lay = (ConstraintLayout) view.findViewById(R.id.layout);
            TextView tvName = (TextView) lay.findViewById(R.id.tv_work_zone);
            targetMachine = tvName.getText().toString();
            mListener.onFragmentClick(this);
        }
    }

    public String getTargetMachine(){
        return this.targetMachine;
    }
}
