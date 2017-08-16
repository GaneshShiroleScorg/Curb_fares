package com.myrescribe.demo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.myrescribe.demo.Custom_Spin_Adapter;
import com.myrescribe.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InCaseofEmergency extends Fragment {


    // Content View Elements

    private android.support.design.widget.TextInputLayout mNameofpersonLay;
    private EditText mNameofperson;
    private Spinner mRelationshipSpinner;
    private android.support.design.widget.TextInputLayout mPhoneNoLay;
    private EditText mPhoneno;
    private android.support.design.widget.TextInputLayout mAlternateNoLay;
    private EditText mAlternate_no;

    // End Of Content View Elements

    private void bindViews(View view) {

        mNameofpersonLay = (android.support.design.widget.TextInputLayout) view.findViewById(R.id.nameofpersonLay);
        mNameofperson = (EditText) view.findViewById(R.id.nameofperson);
        mRelationshipSpinner = (Spinner) view.findViewById(R.id.relationshipSpinner);
        mPhoneNoLay = (android.support.design.widget.TextInputLayout) view.findViewById(R.id.phoneNoLay);
        mPhoneno = (EditText) view.findViewById(R.id.phoneno);
        mAlternateNoLay = (android.support.design.widget.TextInputLayout) view.findViewById(R.id.alternateNoLay);
        mAlternate_no = (EditText) view.findViewById(R.id.alternate_no);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_in_caseof_emergency, container, false);
        bindViews(rootView);

/*// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.relationship_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner*/

        String[] mArrayId = getResources().getStringArray(R.array.relationship_array);

        Custom_Spin_Adapter temp = new Custom_Spin_Adapter(getActivity(), mArrayId, mArrayId);
        mRelationshipSpinner.setAdapter(temp);

        //  mRelationshipSpinner.setAdapter(adapter);

        return rootView;
    }

}
