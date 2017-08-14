package com.myrescribe.demo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.myrescribe.demo.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RiskAnalysis extends Fragment {

    @BindView(R.id.quesOneLayout)
    LinearLayout mQuesOneLayout;
    @BindView(R.id.quesTwoLayout)
    LinearLayout mQuesTwoLayout;
    @BindView(R.id.quesThreeLayout)
    LinearLayout mQuesThreeLayout;
    @BindView(R.id.quesFourLayout)
    LinearLayout mQuesFourLayout;
    @BindView(R.id.quesFiveLayout)
    LinearLayout mQuesFiveLayout;
    @BindView(R.id.quesSixLayout)
    LinearLayout mQuesSixLayout;
    @BindView(R.id.quesSevenLayout)
    LinearLayout mQuesSevenLayout;

    HashMap<Integer, String> selectedAnswerMap = new HashMap<>();

    public RiskAnalysis() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_risk_analysis, container, false);
        ButterKnife.bind(this, inflate);
        initialize();
        return inflate;
    }

    private void initialize() {
        mQuesTwoLayout.setVisibility(View.GONE);
        mQuesThreeLayout.setVisibility(View.GONE);
        mQuesFourLayout.setVisibility(View.GONE);
        mQuesFiveLayout.setVisibility(View.GONE);
        mQuesSixLayout.setVisibility(View.GONE);
        mQuesSevenLayout.setVisibility(View.GONE);
    }

    @OnClick({R.id.quesOneOptionYes, R.id.quesOneOptionNo,
            R.id.quesTwoOptionYes, R.id.quesTwoOptionNo,
            R.id.quesThreeOptionYes, R.id.quesThreeOptionNo,
            R.id.quesFourOptionYes, R.id.quesFourOptionNo,
            R.id.quesFiveOptionYes, R.id.quesFiveOptionNo,
            R.id.quesSixOptionYes, R.id.quesSixOptionNo,
            R.id.quesSevenOptionYes, R.id.quesSevenOptionNo})
    public void onAnswerSelect(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();
        if (radioButton.getId() == R.id.quesOneOptionYes || radioButton.getId() == R.id.quesOneOptionNo) {
            mQuesTwoLayout.setVisibility(View.VISIBLE);
            selectedAnswerMap.put(1, radioButton.getText().toString());
        } else if (radioButton.getId() == R.id.quesTwoOptionYes || radioButton.getId() == R.id.quesTwoOptionNo) {
            mQuesThreeLayout.setVisibility(View.VISIBLE);
            selectedAnswerMap.put(2, radioButton.getText().toString());

        } else if (radioButton.getId() == R.id.quesThreeOptionYes || radioButton.getId() == R.id.quesThreeOptionNo) {
            mQuesFourLayout.setVisibility(View.VISIBLE);
            selectedAnswerMap.put(3, radioButton.getText().toString());

        } else if (radioButton.getId() == R.id.quesFourOptionYes || radioButton.getId() == R.id.quesFourOptionNo) {
            mQuesFiveLayout.setVisibility(View.VISIBLE);
            selectedAnswerMap.put(4, radioButton.getText().toString());

        } else if (radioButton.getId() == R.id.quesFiveOptionYes || radioButton.getId() == R.id.quesFiveOptionNo) {
            mQuesSixLayout.setVisibility(View.VISIBLE);
            selectedAnswerMap.put(5, radioButton.getText().toString());

        } else if (radioButton.getId() == R.id.quesSixOptionYes || radioButton.getId() == R.id.quesSixOptionNo) {
            mQuesSevenLayout.setVisibility(View.VISIBLE);
            selectedAnswerMap.put(6, radioButton.getText().toString());

        } else if (radioButton.getId() == R.id.quesSevenOptionYes || radioButton.getId() == R.id.quesSevenOptionNo) {
            selectedAnswerMap.put(7, radioButton.getText().toString());
            Log.e("DATA", "" + selectedAnswerMap);
        }

    }

}
