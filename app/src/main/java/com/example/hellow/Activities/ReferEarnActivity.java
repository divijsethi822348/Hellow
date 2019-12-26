package com.example.hellow.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

import com.example.hellow.R;

public class ReferEarnActivity extends AppCompatActivity implements View.OnClickListener {

    CardView invite_button, invite_options;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer_earn);
        getSupportActionBar().hide();

        invite_button=findViewById(R.id.invite_button);
        invite_options=findViewById(R.id.invite_options);

        invite_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.invite_button:
                if (count==0){
                    invite_options.setVisibility(View.VISIBLE);
                    count=1;
                }
                else if (count==1){
                    invite_options.setVisibility(View.INVISIBLE);
                    count=0;
                }


                break;


        }

    }
}
