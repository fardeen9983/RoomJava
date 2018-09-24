package com.example.app.roomjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.app.roomjava.Room.User;

public class ViewUser extends AppCompatActivity {
    FloatingActionButton saveChanges, deleteUser;
    EditText name, email, phone;
    User user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);

        saveChanges = findViewById(R.id.save_changes);
        deleteUser = findViewById(R.id.delete_user);

        name = findViewById(R.id.name_edit);
        email = findViewById(R.id.email_edit);
        phone = findViewById(R.id.phone_edit);



        Intent intent = getIntent();
        if(intent!=null){
            user = (User) intent.getSerializableExtra("student");


        }
    }
}
