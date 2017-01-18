package com.example.dani.pantallaselgoibar.fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dani.pantallaselgoibar.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SectionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionFragment extends Fragment {
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

    private OnFragmentInteractionListener mListener;

    public SectionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
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
        CardView cv = (CardView) inflater.inflate(R.layout.section_card, container, false);
        ConstraintLayout cl = (ConstraintLayout)cv.findViewById(R.id.layoutSectionCard);
        TextView tvZone = (TextView) cl.findViewById(R.id.tvZone);
        TextView tvWorking = (TextView) cl.findViewById(R.id.tvWorkingNumber);
        TextView tvHalhWorking = (TextView) cl.findViewById(R.id.tvHalfWorkingNumber);
        TextView tvNotWorking = (TextView) cl.findViewById(R.id.tvNotWorkingNumber);
        tvZone.setText(name);
        tvWorking.setText(String.valueOf(working));
        tvHalhWorking.setText(String.valueOf(halfWorking));
        tvNotWorking.setText(String.valueOf(notWorking));
        return cv;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
