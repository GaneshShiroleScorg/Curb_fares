package com.myrescribe.demo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

    @OnClick({R.id.smokingOptionYes, R.id.smokingOptionNo,
            R.id.haveYouQuitSmokingYes, R.id.haveYouQuitSmokingNo,
            R.id.alcoholYes, R.id.alcoholNo,
            R.id.alcoholSessionEveryday, R.id.alcoholSessionOccasionally, R.id.alcoholSessionFrequently,
            R.id.doYouDrinkLayoutTea, R.id.doYouDrinkLayoutCoffee, R.id.doYouDrinkLayoutCola
    })
    public void onCheckBoxClicked(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();
        if (radioButton.getId() == R.id.smokingOptionYes || radioButton.getId() == R.id.smokingOptionNo) {
            mSmokingOptionSelected = radioButton.getText().toString();
        } else if (radioButton.getId() == R.id.haveYouQuitSmokingYes || radioButton.getId() == R.id.haveYouQuitSmokingNo) {
            mHaveYouQuitOptionSelected = radioButton.getText().toString();
        } else if (radioButton.getId() == R.id.alcoholYes || radioButton.getId() == R.id.alcoholNo) {
            mAlcoholOptionSelected = radioButton.getText().toString();
            if (mAlcoholSessionSelected != null && mAlcoholOptionSelected != null) {
                mDoYouDrinkLayout.setVisibility(View.VISIBLE);
            }
        } else if (radioButton.getId() == R.id.alcoholSessionEveryday || radioButton.getId() == R.id.alcoholSessionOccasionally || radioButton.getId() == R.id.alcoholSessionFrequently) {
            mAlcoholSessionSelected = radioButton.getText().toString();
            if (mAlcoholSessionSelected != null && mAlcoholOptionSelected != null) {
                mDoYouDrinkLayout.setVisibility(View.VISIBLE);
            }
        } else if (radioButton.getId() == R.id.doYouDrinkLayoutTea || radioButton.getId() == R.id.doYouDrinkLayoutCoffee || radioButton.getId() == R.id.doYouDrinkLayoutCola) {
            mDoYouDrinkOptionSelected = radioButton.getText().toString();
        }

        Log.e("DATA", mSmokingOptionSelected + "|" + mHaveYouQuitOptionSelected + "|" + mAlcoholOptionSelected + "|" + mAlcoholSessionSelected + "|" + mDoYouDrinkOptionSelected);
    }
}
