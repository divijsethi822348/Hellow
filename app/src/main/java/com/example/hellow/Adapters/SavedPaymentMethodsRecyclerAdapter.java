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
    List<PaymentModel> pay_list;


    public SavedPaymentMethodsRecyclerAdapter(Context context, List<PaymentModel> pay_list) {
        this.context = context;
        this.pay_list = pay_list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.saved_payment_recycler_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.payment_image.setImageDrawable(pay_list.get(position).getPay_image());
        holder.payment_text.setText(pay_list.get(position).getPay_text().toString());


    }

    @Override
    public int getItemCount() {
        return pay_list.size();
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
