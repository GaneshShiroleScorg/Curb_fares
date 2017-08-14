package com.myrescribe.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SignUpActivity extends AppCompatActivity {

    // Content View Elements

    private ImageView mLogo;
    private EditText mEnter_mobile_number;
    private EditText mEnter_email_id;
    private Button mEnterButton;

    // End Of Content View Elements

    private void bindViews() {
        mLogo = (ImageView) findViewById(R.id.logo);
        mEnter_mobile_number = (EditText) findViewById(R.id.enter_mobile_number);
        mEnter_email_id = (EditText) findViewById(R.id.enter_email_id);
        mEnterButton = (Button) findViewById(R.id.enterButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindViews();

        mEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

       /* mEnter_mobile_number.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    mEnter_mobile_number.setBackgroundDrawable();
                }else {
                    mEnter_mobile_number.setBackgroundDrawable();
                }
            }
        });*/
    }

}
