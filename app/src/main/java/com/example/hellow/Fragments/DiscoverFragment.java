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

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CONTACTS}, 100);
        } else {
            Toast.makeText(getContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
            my_contacts_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
            list.clear();
            getAllContacts();
            my_contacts_recycler_view.setAdapter(new MyContactsRecyclerAdapter(list, getContext()));
        }
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100:
                boolean contacts = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                if (grantResults.length > 0 && contacts) {
                    Toast.makeText(getContext(), "Permission Granted", Toast.LENGTH_SHORT).show();

                } else if (Build.VERSION.SDK_INT > 23 && !shouldShowRequestPermissionRationale(permissions[0])) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Permission Required");
                    builder.setMessage("Permissions are required to run the app");
                    builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                            intent.setData(uri);
                            startActivity(intent);
                        }
                    })
                            .create()
                            .show();
                } else {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CONTACTS}, 10);
                }

        }
    }


    private void getAllContacts() {


        ContentResolver contentResolver = getActivity().getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasPhoneNumber > 0) {
                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    ContactsModel model = new ContactsModel();
                    model.setContactName(name);


                    Cursor phoneCursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id}, null);
                    if (phoneCursor.moveToNext()) {

                        String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        model.setContactNumber(phoneNumber);
                        if (ContactsContract.CommonDataKinds.Phone.PHOTO_URI != null) {
                            String pic = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
                            Log.d("pic", "" + pic);
                            model.setContactPhoto(pic);
                        }

                    }
                    phoneCursor.close();
                    list.add(model);
                }
            }

            cursor.close();

        }


    }

}
