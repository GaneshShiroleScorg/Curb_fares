package com.myrescribe.demo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.myrescribe.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SocialHistory extends Fragment {

    @BindView(R.id.smokingPackPerDay)
    EditText mSmokingPackPerDay;
    @BindView(R.id.smokingHowManyYears)
    EditText mSmokingHowManyYears;
    String mSmokingOptionSelected = null;
    //---------
    @BindView(R.id.haveYouQuitLayout)
    LinearLayout mHaveYouQuitLayout;
    @BindView(R.id.haveYouQuitSmoking_HowManyYears)
    EditText mHaveYouQuitSmoking_HowManyYears;
    String mHaveYouQuitOptionSelected = null;

    //---
    @BindView(R.id.alcoholLayout)
    LinearLayout mAlcoholLayout;
    String mAlcoholOptionSelected = null;
    String mAlcoholSessionSelected = null;

    //-------------
    @BindView(R.id.doYouDrinkLayout)
    LinearLayout mDoYouDrinkLayout;
    String mDoYouDrinkOptionSelected = null;

    @BindView(R.id.doYouDrinkLayout_HowMuchPerDay)
    EditText doYouDrinkLayout_HowMuchCupsPerDay;

    public SocialHistory() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View inflate = inflater.inflate(R.layout.fragment_social_history, container, false);
        ButterKnife.bind(this, inflate);
        initialize();
        return inflate;
    }

    private void initialize() {
        mHaveYouQuitLayout.setVisibility(View.GONE);
        mAlcoholLayout.setVisibility(View.GONE);
        mDoYouDrinkLayout.setVisibility(View.GONE);
        mSmokingHowManyYears.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (mSmokingOptionSelected != null && mSmokingPackPerDay.getText().toString().trim().length() != 0 &&
                        editable.toString().trim().length() != 0) {
                    mHaveYouQuitLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        mHaveYouQuitSmoking_HowManyYears.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (mHaveYouQuitOptionSelected != null &&
                        editable.toString().trim().length() != 0) {
                    mAlcoholLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        doYouDrinkLayout_HowMuchCupsPerDay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @OnClick({R.id.smokingOptionYes, R.id.smokingOptionNo})
    public void onSmokingOptionClicked(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();
        switch (radioButton.getId()) {
            case R.id.smokingOptionYes:
                if (checked) {
                    mSmokingOptionSelected = radioButton.getText().toString();
                }
                break;
            case R.id.smokingOptionNo:
                if (checked) {
                    mSmokingOptionSelected = radioButton.getText().toString();
                }
                break;
        }
    }

    @OnClick({R.id.haveYouQuitSmokingYes, R.id.haveYouQuitSmokingNo})
    public void onHaveYouQuitSmokingOptionClicked(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();
        switch (radioButton.getId()) {
            case R.id.haveYouQuitSmokingYes:
                if (checked) {
                    mHaveYouQuitOptionSelected = radioButton.getText().toString();
                }
                break;
            case R.id.haveYouQuitSmokingNo:
                if (checked) {
                    mHaveYouQuitOptionSelected = radioButton.getText().toString();
                }
                break;
        }
    }

    @OnClick({R.id.alcoholYes, R.id.alcoholNo})
    public void onAlcoholOptionClicked(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();
        switch (radioButton.getId()) {
            case R.id.alcoholYes:
                if (checked) {
                    mAlcoholOptionSelected = radioButton.getText().toString();
                }
                break;
            case R.id.alcoholNo:
                if (checked) {
                    mAlcoholOptionSelected = radioButton.getText().toString();
                }
                break;
        }
        if (mAlcoholSessionSelected != null && mAlcoholOptionSelected != null) {
            mDoYouDrinkLayout.setVisibility(View.VISIBLE);
        }
    }

    @OnClick({R.id.alcoholSessionEveryday, R.id.alcoholSessionOccasionally, R.id.alcoholSessionFrequently})
    public void onAlcoholSessionOptionClicked(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();
        switch (radioButton.getId()) {
            case R.id.alcoholSessionEveryday:
                if (checked) {
                    mAlcoholSessionSelected = radioButton.getText().toString();
                }
                break;
            case R.id.alcoholSessionOccasionally:
                if (checked) {
                    mAlcoholSessionSelected = radioButton.getText().toString();
                }
                break;
            case R.id.alcoholSessionFrequently:
                if (checked) {
                    mAlcoholSessionSelected = radioButton.getText().toString();
                }
                break;
        }
        if (mAlcoholSessionSelected != null && mAlcoholOptionSelected != null) {
            mDoYouDrinkLayout.setVisibility(View.VISIBLE);
        }
    }


    @OnClick({R.id.doYouDrinkLayoutTea, R.id.doYouDrinkLayoutCoffee, R.id.doYouDrinkLayoutCola})
    public void onDoYouDrinkOptionClicked(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();
        switch (radioButton.getId()) {
            case R.id.doYouDrinkLayoutTea:
                if (checked) {
                    mDoYouDrinkOptionSelected = radioButton.getText().toString();
                }
                break;
            case R.id.doYouDrinkLayoutCoffee:
                if (checked) {
                    mDoYouDrinkOptionSelected = radioButton.getText().toString();
                }
                break;
            case R.id.doYouDrinkLayoutCola:
                if (checked) {
                    mDoYouDrinkOptionSelected = radioButton.getText().toString();
                }
                break;
        }
    }

}
