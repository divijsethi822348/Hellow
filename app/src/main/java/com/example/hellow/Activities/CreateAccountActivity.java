package com.example.hellow.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hellow.R;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        getSupportActionBar().hide();
    }
}
