package com.example.hellow.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.hellow.Fragments.ChatFragment;
import com.example.hellow.Fragments.DiscoverFragment;
import com.example.hellow.Fragments.EarnedFragment;
import com.example.hellow.Models.ContactsModel;
import com.example.hellow.R;
import com.example.hellow.Util.App;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout chat,discover,earned;
    FrameLayout main_frame;
    List<ContactsModel> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        main_frame=findViewById(R.id.main_frame);
        chat=findViewById(R.id.chats);
        discover=findViewById(R.id.discover);
        earned=findViewById(R.id.earned);
        SelectFragment(new ChatFragment());

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 100);
        } else {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            if (App.getSingleton().getList()==null){
                getAllContacts();
                App.getSingleton().setList(list);
            }

        }

        setOnClickListener();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100:
                boolean contacts = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                if (grantResults.length > 0 && contacts) {
                    Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();

                } else if (Build.VERSION.SDK_INT > 23 && !shouldShowRequestPermissionRationale(permissions[0])) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Permission Required");
                    builder.setMessage("Permissions are required to run the app");
                    builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package", MainActivity.this.getPackageName(), null);
                            intent.setData(uri);
                            startActivity(intent);
                        }
                    })
                            .create()
                            .show();
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 10);
                }

        }
    }


    private void getAllContacts() {


        ContentResolver contentResolver =this.getContentResolver();
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

    private void setOnClickListener() {
        chat.setOnClickListener(this);
        discover.setOnClickListener(this);
        earned.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.chats:
                SelectFragment(new ChatFragment());
                break;

            case R.id.discover:
                SelectFragment(new DiscoverFragment());
                break;


            case R.id.earned:
                SelectFragment(new EarnedFragment());
                break;

        }

    }

    private void SelectFragment(Fragment tab1) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.main_frame,tab1);
        transaction.commit();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,tab1);

    }
}
