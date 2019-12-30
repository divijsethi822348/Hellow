package com.example.hellow.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hellow.R;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {
    TextView profile, settings, refer, contact, feedback, faq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        getSupportActionBar().hide();
        setIds();
        setCicks();


    }

    private void setCicks() {
        profile.setOnClickListener(this);
        settings.setOnClickListener(this);
        refer.setOnClickListener(this);
        contact.setOnClickListener(this);
        feedback.setOnClickListener(this);
        faq.setOnClickListener(this);

    }

    private void setIds() {
        profile = findViewById(R.id.profile_options);
        settings = findViewById(R.id.settings_options);
        refer = findViewById(R.id.refer_earn_options);
        contact = findViewById(R.id.contact_options);
        feedback = findViewById(R.id.feedback_options);
        faq = findViewById(R.id.faq_options);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.profile_options:
                startActivity(new Intent(this, MyProfileActivity.class));
                break;

            case R.id.settings_options:
                startActivity(new Intent(this, AccountSettingsActivity.class));
                break;

            case R.id.contact_options:
                startActivity(new Intent(this, ContactUsActivity.class));
                break;

            case R.id.refer_earn_options:
                startActivity(new Intent(this, ReferEarnActivity.class));
                break;

            case R.id.feedback_options:
                startActivity(new Intent(this, FeedbackActivity.class));
                break;


        }
    }
}
