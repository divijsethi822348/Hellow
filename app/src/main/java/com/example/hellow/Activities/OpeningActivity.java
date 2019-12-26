package com.example.hellow.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.hellow.R;

public class OpeningActivity extends AppCompatActivity {

    RelativeLayout login_button, create_account_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        getSupportActionBar().hide();
        login_button=findViewById(R.id.login_button);
        create_account_button=findViewById(R.id.create_account_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpeningActivity.this, GetOtpActivity.class));
            }
        });

        create_account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpeningActivity.this, CreateAccountActivity.class));
            }
        });
    }
}
