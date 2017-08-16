package com.myrescribe.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.myrescribe.demo.fragments.HealthProblemFlowSheet;
import com.myrescribe.demo.fragments.InCaseofEmergency;
import com.myrescribe.demo.fragments.InsuranceInformation;
import com.myrescribe.demo.fragments.PatientInformationFragment;
import com.myrescribe.demo.fragments.RiskAnalysis;
import com.myrescribe.demo.fragments.SocialHistory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mSubmitButton = (Button) findViewById(R.id.submitButton);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mSubmitButton.getText().toString();
                if (s.equalsIgnoreCase(getString(R.string.next))) {
                    int currentItem = viewPager.getCurrentItem();
                    viewPager.setCurrentItem(currentItem + 1, true);
                } else if (s.equalsIgnoreCase(getString(R.string.submit))) {
                    Toast.makeText(MainActivity.this, "Form submitted successfully.", Toast.LENGTH_LONG).show();
                }
            }
        });
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View focus = getCurrentFocus();
                if (focus != null) {
                    hiddenKeyboard(focus);
                }
                int position = tab.getPosition();

                if (position > 4) {
                    mSubmitButton.setText(getString(R.string.submit));
                } else {
                    mSubmitButton.setText(getString(R.string.next));

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View focus = getCurrentFocus();
                if (focus != null) {
                    hiddenKeyboard(focus);
                }
                int position = tab.getPosition();

                if (position > 4) {
                    mSubmitButton.setText(getString(R.string.submit));
                } else {
                    mSubmitButton.setText(getString(R.string.next));

                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                View focus = getCurrentFocus();
                if (focus != null) {
                    hiddenKeyboard(focus);
                }
                int position = tab.getPosition();
                if (position > 4) {
                    mSubmitButton.setText(getString(R.string.submit));
                } else {
                    mSubmitButton.setText(getString(R.string.next));

                }
            }
        });
    }

    private void hiddenKeyboard(View v) {
        InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        keyboard.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PatientInformationFragment(), "Patient Information");
        adapter.addFragment(new InsuranceInformation(), "Insurance Information");
        adapter.addFragment(new InCaseofEmergency(), "In Case of Emergency");
        adapter.addFragment(new HealthProblemFlowSheet(), "Health Problem Flow Sheet");
        adapter.addFragment(new SocialHistory(), "Social History");
        adapter.addFragment(new RiskAnalysis(), "Risk Analysis");

        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
