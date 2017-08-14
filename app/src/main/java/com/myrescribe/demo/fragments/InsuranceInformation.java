package com.myrescribe.demo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.myrescribe.demo.Custom_Spin_Adapter;
import com.myrescribe.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsuranceInformation extends Fragment implements AdapterView.OnItemSelectedListener{


    @BindView(R.id.insuredName)
    EditText insuredName;
    @BindView(R.id.groupNo)
    Spinner groupNo;
    @BindView(R.id.policyId)
    EditText policyId;
    @BindView(R.id.subscriberName)
    EditText subscriberName;
    @BindView(R.id.insuredSsNo)
    EditText insuredSsNo;
    @BindView(R.id.birthDate)
    EditText birthDate;
    @BindView(R.id.patientRelationShip)
    TextView patientRelationShip;
    @BindView(R.id.self)
    RadioButton self;
    @BindView(R.id.spouse)
    RadioButton spouse;
    @BindView(R.id.child)
    RadioButton child;
    @BindView(R.id.other)
    RadioButton other;
    @BindView(R.id.subscriberInfo)
    LinearLayout subscriberInfo;
    @BindView(R.id.relationship)
    LinearLayout relationship;
    private String mSelectedId = "";

    Unbinder unbinder;
    private String[] mArrayId;
    Custom_Spin_Adapter mCustomSpinAdapterForGroupNo;

    public InsuranceInformation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_insurance_information, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        mArrayId = getResources().getStringArray(R.array.ids);
        mCustomSpinAdapterForGroupNo = new Custom_Spin_Adapter(getActivity(), mArrayId, getResources().getStringArray(R.array.group_no));
        groupNo.setAdapter(mCustomSpinAdapterForGroupNo);
        policyId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(insuredName.getText().length()!=0&&policyId.getText().length()!=0&&!mSelectedId.equalsIgnoreCase(getString(R.string.select_group)))
               subscriberInfo.setVisibility(View.VISIBLE);
            }
        });
        insuredName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(insuredName.getText().length()!=0&&policyId.getText().length()!=0&&!mSelectedId.equalsIgnoreCase(getString(R.string.select_group)))
                    subscriberInfo.setVisibility(View.VISIBLE);
            }
        });

        subscriberName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(subscriberName.getText().length()!=0&&insuredSsNo.getText().length()!=0&&birthDate.getText().length()!=0)
                    relationship.setVisibility(View.VISIBLE);
            }
        });
        birthDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(subscriberName.getText().length()!=0&&insuredSsNo.getText().length()!=0&&birthDate.getText().length()!=0)
                    relationship.setVisibility(View.VISIBLE);

            }
        });
        insuredSsNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(subscriberName.getText().length()!=0&&insuredSsNo.getText().length()!=0&&birthDate.getText().length()!=0)
                    relationship.setVisibility(View.VISIBLE);

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // saveEnteredData();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.groupNo) {
            int indexSselectedId = parent.getSelectedItemPosition();
            mArrayId = getResources().getStringArray(R.array.group_no);
            mSelectedId = mArrayId[indexSselectedId];
            if(insuredName.getText().length()!=0&&policyId.getText().length()!=0&&!mSelectedId.equalsIgnoreCase(getString(R.string.select_group)))
                subscriberInfo.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
