package com.example.hellow.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.hellow.R;

public class AccountSettingsActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout privacy, payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        getSupportActionBar().hide();
        setIds();
        setClicks();
    }

    private void setClicks() {
        privacy.setOnClickListener(this);
        payment.setOnClickListener(this);

    }


    private void setIds() {
        privacy=findViewById(R.id.privacy);
        payment=findViewById(R.id.payment);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.privacy:
                startActivity(new Intent(this, PrivacyActivity.class));
                break;

            case R.id.payment:
                startActivity(new Intent(this, PaymentActivity.class));
                break;

        }

    }
}
