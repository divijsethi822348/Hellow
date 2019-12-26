package com.example.hellow.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hellow.R;

public class GetOtpActivity extends AppCompatActivity {

    RelativeLayout get_otp;
    TextView create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_otp);
        getSupportActionBar().hide();
        get_otp=findViewById(R.id.get_otp_button);
        create=findViewById(R.id.create_account);
        get_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetOtpActivity.this, MainActivity.class));
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetOtpActivity.this, CreateAccountActivity.class));
            }
        });
    }




}
