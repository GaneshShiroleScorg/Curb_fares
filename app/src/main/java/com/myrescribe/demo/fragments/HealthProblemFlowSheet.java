package com.myrescribe.demo.fragments;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.myrescribe.demo.Custom_Spin_Adapter;
import com.myrescribe.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HealthProblemFlowSheet extends Fragment {

    @BindView(R.id.check_comp_1)
    CheckBox checkComp1;
    @BindView(R.id.check_comp_2)
    CheckBox checkComp2;
    @BindView(R.id.check_comp_3)
    CheckBox checkComp3;
    @BindView(R.id.check_comp_4)
    CheckBox checkComp4;
    @BindView(R.id.check_comp_5)
    CheckBox checkComp5;
    @BindView(R.id.check_comp_6)
    CheckBox checkComp6;
    @BindView(R.id.check_comp_7)
    CheckBox checkComp7;
    @BindView(R.id.check_comp_8)
    CheckBox checkComp8;
    @BindView(R.id.others)
    EditText others;
    @BindView(R.id.othersLay)
    TextInputLayout othersLay;
    @BindView(R.id.year)
    EditText year;
    @BindView(R.id.yearLay)
    TextInputLayout yearLay;
    @BindView(R.id.operation)
    EditText operation;
    @BindView(R.id.operationLay)
    TextInputLayout operationLay;
    @BindView(R.id.complications)
    EditText complications;
    @BindView(R.id.complicationsLay)
    TextInputLayout complicationsLay;
    @BindView(R.id.secondLay)
    LinearLayout secondLay;
    @BindView(R.id.historySpinner)
    Spinner historySpinner;
    @BindView(R.id.outcome)
    EditText outcome;
    @BindView(R.id.outcomeLay)
    TextInputLayout outcomeLay;
    @BindView(R.id.location)
    EditText location;
    @BindView(R.id.locationLay)
    TextInputLayout locationLay;
    @BindView(R.id.thirdLay)
    LinearLayout thirdLay;
    @BindView(R.id.check_history_1)
    CheckBox checkHistory1;
    @BindView(R.id.check_history_2)
    CheckBox checkHistory2;
    @BindView(R.id.check_history_3)
    CheckBox checkHistory3;
    @BindView(R.id.fourthLay)
    LinearLayout fourthLay;
    @BindView(R.id.allergies)
    EditText allergies;
    @BindView(R.id.allergiesLay)
    TextInputLayout allergiesLay;
    @BindView(R.id.iconLay)
    LinearLayout iconLay;
    @BindView(R.id.fifthLay)
    LinearLayout fifthLay;
    Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_health_problem_flow_sheet, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        secondLay.setVisibility(View.GONE);
        thirdLay.setVisibility(View.GONE);
        fourthLay.setVisibility(View.GONE);
        fifthLay.setVisibility(View.GONE);

        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.history_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        historySpinner.setAdapter(adapter);*/

        String[] mArrayId = getResources().getStringArray(R.array.history_array);

        Custom_Spin_Adapter temp = new Custom_Spin_Adapter(getActivity(), mArrayId, mArrayId);
        historySpinner.setAdapter(temp);

        historySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1)
                    fourthLay.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        others.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0)
                    secondLay.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        year.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0)
                    thirdLay.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        operation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0)
                    thirdLay.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        complications.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0)
                    thirdLay.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        outcome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0)
                    fourthLay.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        location.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0)
                    fourthLay.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.check_comp_1, R.id.check_comp_2, R.id.check_comp_3, R.id.check_comp_4, R.id.check_comp_5, R.id.check_comp_6, R.id.check_comp_7, R.id.check_comp_8, R.id.check_history_1, R.id.check_history_2, R.id.check_history_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.check_comp_1:
            case R.id.check_comp_2:
            case R.id.check_comp_3:
            case R.id.check_comp_4:
            case R.id.check_comp_5:
            case R.id.check_comp_6:
            case R.id.check_comp_7:
            case R.id.check_comp_8:
                secondLay.setVisibility(View.VISIBLE);
                break;

            case R.id.check_history_1:
            case R.id.check_history_2:
            case R.id.check_history_3:
                fifthLay.setVisibility(View.VISIBLE);
                break;
        }
    }
}
