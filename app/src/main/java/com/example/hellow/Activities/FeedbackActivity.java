package com.example.hellow.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.hellow.R;
import com.hsalf.smilerating.SmileRating;

public class FeedbackActivity extends AppCompatActivity {

    SmileRating smileRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().hide();
        smileRating=findViewById(R.id.rating);
        SmileySelectionListeners();
        OnRatingSelectedListeners();



    }

    private void OnRatingSelectedListeners() {
        smileRating.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {
                Toast.makeText(FeedbackActivity.this, ""+level, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void SmileySelectionListeners() {

        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                switch (smiley) {
                    case SmileRating.BAD:
                        Log.i("TAG", "Bad");
                        break;
                    case SmileRating.GOOD:
                        Log.i("TAG", "Good");
                        break;
                    case SmileRating.GREAT:
                        Log.i("TAG", "Great");
                        break;
                    case SmileRating.OKAY:
                        Log.i("TAG", "Okay");
                        break;
                    case SmileRating.TERRIBLE:
                        Log.i("TAG", "Terrible");
                        break;
                }
            }
        });
    }
}
