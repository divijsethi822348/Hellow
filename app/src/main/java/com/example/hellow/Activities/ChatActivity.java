package com.example.hellow.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hellow.R;

public class ChatActivity extends AppCompatActivity {

    ImageView attach;
    LinearLayout attach_file;
    int check=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        getSupportActionBar().hide();
        attach=findViewById(R.id.attach);
        attach_file=findViewById(R.id.attach_file);
        attach_file.setVisibility(View.GONE);
        attach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check==1){
                   attach_file.setVisibility(View.GONE);
                   check--;
                }else if (check==0){
                    attach_file.setVisibility(View.VISIBLE);
                    check++;
                }
            }
        });


    }
}
