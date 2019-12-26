package com.example.hellow.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hellow.Activities.ChatActivity;
import com.example.hellow.Models.ContactsModel;
import com.example.hellow.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyContactsRecyclerAdapter extends RecyclerView.Adapter<MyContactsRecyclerAdapter.Holder> {

    List<ContactsModel> list;
    Context context;


    public MyContactsRecyclerAdapter(List<ContactsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.my_contacts_recycler_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ContactsModel model=list.get(position);
        holder.contact_name.setText(model.getContactName());
        Picasso.with(context).load(model.getContactPhoto()).into(holder.contact_image);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        CircleImageView contact_image;
        TextView contact_name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            contact_image=itemView.findViewById(R.id.my_contacts_user_image);
            contact_name=itemView.findViewById(R.id.my_contacts_user_name);

        }
    }
}
