package com.example.hellow.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hellow.Models.PaymentModel;
import com.example.hellow.R;

import java.util.List;

public class SavedPaymentMethodsRecyclerAdapter extends RecyclerView.Adapter<SavedPaymentMethodsRecyclerAdapter.Holder> {

    Context context;


    public SavedPaymentMethodsRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.saved_payment_recycler_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView payment_image;
        TextView payment_text;

        public Holder(@NonNull View itemView) {
            super(itemView);
            payment_image=itemView.findViewById(R.id.payment_image);
            payment_text=itemView.findViewById(R.id.payment_text);


        }
    }
}
