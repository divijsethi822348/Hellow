package com.example.hellow.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.hellow.Fragments.ChatFragment;
import com.example.hellow.Fragments.DiscoverFragment;
import com.example.hellow.Fragments.EarnedFragment;
import com.example.hellow.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout chat,discover,earned;
    FrameLayout main_frame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        main_frame=findViewById(R.id.main_frame);
        chat=findViewById(R.id.chats);
        discover=findViewById(R.id.discover);
        earned=findViewById(R.id.earned);
        SelectFragment(new ChatFragment());
        setOnClickListener();

    }

    private void setOnClickListener() {
        chat.setOnClickListener(this);
        discover.setOnClickListener(this);
        earned.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.chats:
                SelectFragment(new ChatFragment());
                break;

            case R.id.discover:
                SelectFragment(new DiscoverFragment());
                break;


            case R.id.earned:
                SelectFragment(new EarnedFragment());
                break;

        }

    }

    private void SelectFragment(Fragment tab1) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.main_frame,tab1);
        transaction.commit();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,tab1);

    }
}
