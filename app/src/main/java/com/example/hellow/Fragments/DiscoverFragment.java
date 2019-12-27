package com.example.hellow.Fragments;


import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hellow.Activities.OptionsActivity;
import com.example.hellow.Adapters.MyContactsRecyclerAdapter;
import com.example.hellow.Models.ContactsModel;
import com.example.hellow.R;
import com.example.hellow.Util.App;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends Fragment {
    List<ContactsModel> list = new ArrayList<>();
    RecyclerView my_contacts_recycler_view;
    ImageView menu;


    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        my_contacts_recycler_view = view.findViewById(R.id.contacts_recycler);
        menu = view.findViewById(R.id.menu_contacts);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OptionsActivity.class));
            }
        });
        my_contacts_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();
        list = App.getSingleton().getList();
        my_contacts_recycler_view.setAdapter(new MyContactsRecyclerAdapter(list, getContext()));


        return view;
    }

}
