package com.example.hellow.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hellow.Activities.ChatActivity;
import com.example.hellow.R;

public class MyChatsRecyclerAdapter extends RecyclerView.Adapter<MyChatsRecyclerAdapter.Holder> {

    Context context;

    public MyChatsRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.my_chats_recycler_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class Holder extends RecyclerView.ViewHolder {
        RelativeLayout chat_tile;
        public Holder(@NonNull View itemView) {
            super(itemView);
            chat_tile=itemView.findViewById(R.id.chat_tile);
            chat_tile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, ChatActivity.class));
                }
            });

        }
    }
}
