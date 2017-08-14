package com.myrescribe.demo.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.myrescribe.demo.Custom_Spin_Adapter;
import com.myrescribe.demo.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class PatientInformationFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.lastName)
    EditText lastName;
    @BindView(R.id.firstname)
    EditText firstname;
    @BindView(R.id.middleName)
    EditText middleName;
    @BindView(R.id.martialStatus)
    Spinner martialStatus;
    @BindView(R.id.dob)
    EditText dob;
    @BindView(R.id.gender)
    Spinner gender;
    @BindView(R.id.address1)
    EditText address1;
    @BindView(R.id.address2)
    EditText address2;
    @BindView(R.id.city)
    EditText city;
    @BindView(R.id.state)
    EditText state;
    @BindView(R.id.zipCode)
    EditText zipCode;
    @BindView(R.id.socialSecurityNo)
    EditText socialSecurityNo;
    @BindView(R.id.phoneNo)
    EditText phoneNo;
    @BindView(R.id.phoneNoUser)
    EditText phoneNoUser;
    @BindView(R.id.emailid)
    EditText emailid;
    @BindView(R.id.occupation)
    EditText occupation;
    @BindView(R.id.personalDetails)
    LinearLayout personalDetails;
    @BindView(R.id.userPatientInfo)
    LinearLayout userPatientInfo;
    @BindView(R.id.loginInfoUser)
    LinearLayout loginInfoUser;
    @BindView(R.id.addressLayout)
    LinearLayout addressLayout;
    @BindView(R.id.otherDetails)
    LinearLayout otherDetails;
    Unbinder unbinder;
    private String[] mArrayId;
    private String mSelectedId = "";
    private String mSelectedMaritalStatus = "";

    Custom_Spin_Adapter mCustomSpinAdapterForGender;
    Custom_Spin_Adapter mCustomSpinAdapterForMaritalStatus;
    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    public PatientInformationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_patient_information, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        setDateTimeField();
        mArrayId = getResources().getStringArray(R.array.ids);
        mCustomSpinAdapterForMaritalStatus = new Custom_Spin_Adapter(getActivity(), mArrayId, getResources().getStringArray(R.array.marital_status));
        martialStatus.setAdapter(mCustomSpinAdapterForMaritalStatus);
        mCustomSpinAdapterForGender = new Custom_Spin_Adapter(getActivity(), mArrayId, getResources().getStringArray(R.array.gender));
        gender.setAdapter(mCustomSpinAdapterForGender);
        gender.setOnItemSelectedListener(this);
        dob.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (dob.getText().length() != 0 && address1.getText().length() != 0 && !mSelectedId.equalsIgnoreCase(getString(R.string.select_gender)) && !mSelectedMaritalStatus.equalsIgnoreCase(getString(R.string.select_marital_status)) && address2.getText().length() != 0 && city.getText().length() != 0 && state.getText().length() != 0 && zipCode.getText().length() != 0) {
                    otherDetails.setVisibility(View.VISIBLE);
                }
            }
        });
        address1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (dob.getText().length() != 0 && address1.getText().length() != 0 && !mSelectedId.equalsIgnoreCase(getString(R.string.select_gender)) && !mSelectedMaritalStatus.equalsIgnoreCase(getString(R.string.select_marital_status)) && address2.getText().length() != 0 && city.getText().length() != 0 && state.getText().length() != 0 && zipCode.getText().length() != 0) {
                    otherDetails.setVisibility(View.VISIBLE);
                }
            }
        });
        address2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (dob.getText().length() != 0 && address1.getText().length() != 0 && !mSelectedId.equalsIgnoreCase(getString(R.string.select_gender)) && !mSelectedMaritalStatus.equalsIgnoreCase(getString(R.string.select_marital_status)) && address2.getText().length() != 0 && city.getText().length() != 0 && state.getText().length() != 0 && zipCode.getText().length() != 0) {
                    otherDetails.setVisibility(View.VISIBLE);
                }
            }
        });
        city.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (dob.getText().length() != 0 && address1.getText().length() != 0 && !mSelectedId.equalsIgnoreCase(getString(R.string.select_gender)) && !mSelectedMaritalStatus.equalsIgnoreCase(getString(R.string.select_marital_status)) && address2.getText().length() != 0 && city.getText().length() != 0 && state.getText().length() != 0 && zipCode.getText().length() != 0) {
                    otherDetails.setVisibility(View.VISIBLE);
                }
            }
        });
        state.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (dob.getText().length() != 0 && address1.getText().length() != 0 && !mSelectedId.equalsIgnoreCase(getString(R.string.select_gender)) && !mSelectedMaritalStatus.equalsIgnoreCase(getString(R.string.select_marital_status)) && address2.getText().length() != 0 && city.getText().length() != 0 && state.getText().length() != 0 && zipCode.getText().length() != 0) {
                    otherDetails.setVisibility(View.VISIBLE);
                }
            }
        });
        zipCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (dob.getText().length() != 0 && address1.getText().length() != 0 && !mSelectedId.equalsIgnoreCase(getString(R.string.select_gender)) && !mSelectedMaritalStatus.equalsIgnoreCase(getString(R.string.select_marital_status)) && address2.getText().length() != 0 && city.getText().length() != 0 && state.getText().length() != 0 && zipCode.getText().length() != 0) {
                    otherDetails.setVisibility(View.VISIBLE);
                }
            }
        });
        middleName.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (lastName.getText().length() != 0 && firstname.getText().length() != 0 && middleName.getText().length() != 0) {
                    personalDetails.setVisibility(View.VISIBLE);
                }
                // TODO Auto-generated method stub
            }
        });
        lastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (lastName.getText().length() != 0 && firstname.getText().length() != 0 && middleName.getText().length() != 0) {
                    personalDetails.setVisibility(View.VISIBLE);
                }
            }
        });
        firstname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (lastName.getText().length() != 0 && firstname.getText().length() != 0 && middleName.getText().length() != 0) {
                    personalDetails.setVisibility(View.VISIBLE);
                }
            }
        });

        phoneNoUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (phoneNoUser.getText().length() == 10)
                    userPatientInfo.setVisibility(View.VISIBLE);
            }
        });
        emailid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (emailid.getText().toString().contains("@"))
                    userPatientInfo.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // saveEnteredData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.gender) {
            int indexSselectedId = parent.getSelectedItemPosition();
            mArrayId = getResources().getStringArray(R.array.gender);
            mSelectedId = mArrayId[indexSselectedId];
            addressLayout.setVisibility(View.VISIBLE);
        } else if (parent.getId() == R.id.martialStatus) {
            int indexSselectedId = parent.getSelectedItemPosition();
            mArrayId = getResources().getStringArray(R.array.marital_status);
            mSelectedMaritalStatus = mArrayId[indexSselectedId];

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @OnClick(R.id.dob)
    public void onViewClicked() {
        fromDatePickerDialog.show();
    }

/////////////////////////////////////////////////////

    private void setDateTimeField() {

        dob.setFocusable(false);
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        Calendar newCalendar = Calendar.getInstance();

        fromDatePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                dob.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }
}
