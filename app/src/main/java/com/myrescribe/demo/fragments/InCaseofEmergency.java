package com.myrescribe.demo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myrescribe.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InCaseofEmergency extends Fragment {


    public InCaseofEmergency() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_in_caseof_emergency, container, false);
    }

}
