package com.example.dani.pantallaselgoibar.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dani.pantallaselgoibar.R;
import com.example.dani.pantallaselgoibar.classes.Machine;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MachineStatusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MachineStatusFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NAME = "name";
    private static final String ARG_STATUS = "status";

    // TODO: Rename and change types of parameters
    private String name;
    private int status;

    private OnFragmentInteractionListener mListener;

    public MachineStatusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param name Parameter 1.
     * @param status Parameter 2.
     * @return A new instance of fragment MachineStatusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MachineStatusFragment newInstance(String name, int status) {
        MachineStatusFragment fragment = new MachineStatusFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putInt(ARG_STATUS, status);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            status = getArguments().getInt(ARG_STATUS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CardView cv = (CardView) inflater.inflate(R.layout.card_machine, container, false);
        TextView tvName = (TextView) cv.findViewById(R.id.tv_machine_name);
        ImageView ivStatus = (ImageView) cv.findViewById(R.id.iv_machine_status);

        tvName.setText(name);
        switch (status){
            case Machine.STATUS_WORKING:
                ivStatus.setImageResource(R.drawable.ic_working);
                break;
            case Machine.STATUS_HALF_WORKING:
                ivStatus.setImageResource(R.drawable.ic_half_working);
                break;
            case Machine.STATUS_NOT_WORKING:
                ivStatus.setImageResource(R.drawable.ic_not_working);
                break;
        }
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
}
