package com.example.hellow.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hellow.Adapters.MyReferalsRecyclerAdapter;
import com.example.hellow.Adapters.SubsciptionPlansRecycerAdapter;
import com.example.hellow.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EarnedFragment extends Fragment {

    RecyclerView my_referals,sub_plans;


    public EarnedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_earned, container, false);
        my_referals=view.findViewById(R.id.my_referals_recycler);
        sub_plans=view.findViewById(R.id.subscription_plans_recycler);
        my_referals.setLayoutManager(new GridLayoutManager(getContext(),3,RecyclerView.HORIZONTAL,false));
        sub_plans.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));

        my_referals.setAdapter(new MyReferalsRecyclerAdapter(getContext()));
        sub_plans.setAdapter(new SubsciptionPlansRecycerAdapter(getContext()));


        return view;
    }

}
