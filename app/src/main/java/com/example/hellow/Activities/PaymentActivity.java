package com.example.hellow.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hellow.Adapters.SavedPaymentMethodsRecyclerAdapter;
import com.example.hellow.Models.PaymentModel;
import com.example.hellow.R;

import java.util.ArrayList;
import java.util.List;


public class PaymentActivity extends AppCompatActivity {
    RecyclerView saved_payment;
    List<PaymentModel> pay_list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().hide();
        saved_payment=findViewById(R.id.saved_payment_recycler);
        saved_payment.setLayoutManager(new LinearLayoutManager(this));

        saved_payment.setAdapter(new SavedPaymentMethodsRecyclerAdapter(this));
    }
}
