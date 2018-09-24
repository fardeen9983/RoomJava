package com.example.app.roomjava;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.app.roomjava.Room.User;
import com.example.app.roomjava.Room.UserDB;

public class AddUser extends AppCompatActivity {

    FloatingActionButton addUser;
    EditText name, phone, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        addUser = findViewById(R.id.add_user);

        name = findViewById(R.id.name_add);
        phone = findViewById(R.id.phone_add);
        email = findViewById(R.id.email_add);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(name.getText().toString(),
                        Long.parseLong(phone.getText().toString()),
                        email.getText().toString());
                UserDB.getInstance(getApplicationContext()).userDAO().insert(user);
                finishAndRemoveTask();
            }
        });
    }
}
