package com.example.hellow.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hellow.Activities.OptionsActivity;
import com.example.hellow.Adapters.MyChatsRecyclerAdapter;
import com.example.hellow.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {

    RecyclerView last_chats_recycler;
    ImageView menu;


    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_chat, container, false);
        setIds(view);

        return view;
    }

    private void setIds(final View view) {
        last_chats_recycler=view.findViewById(R.id.my_chats_recycler);
        menu=view.findViewById(R.id.menu);
        last_chats_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        last_chats_recycler.setAdapter(new MyChatsRecyclerAdapter(getContext()));
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OptionsActivity.class));
            }
        });

    }

}
