package com.example.hellow.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hellow.R;

public class MyProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        getSupportActionBar().hide();
    }
}
