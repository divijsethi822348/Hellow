package com.example.hellow.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hellow.R;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getSupportActionBar().hide();
    }
}
