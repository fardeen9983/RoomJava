package com.example.app.roomjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.app.roomjava.Room.User;
import com.example.app.roomjava.Room.UserDB;

public class ViewUser extends AppCompatActivity {
    FloatingActionButton saveChanges, deleteUser;
    EditText name, email, phone;
    User user = null;
    @SuppressLint("SetTextI18n")
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

            name.setText(user.getName());
            email.setText(user.getEmail());
            phone.setText(user.getPhone().toString());
        }

        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user1 = new User(name.getText().toString(),
                        Long.parseLong(phone.getText().toString()),
                        email.getText().toString());
                UserDB.getInstance(getApplicationContext()).userDAO().update(user1);
                finishAndRemoveTask();
            }
        });

        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user!=null)
                    UserDB.getInstance(getApplicationContext()).userDAO().delete(user.getId());
                finishAndRemoveTask();
            }
        });
    }
}
