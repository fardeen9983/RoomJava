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
        if (intent != null) {
            user = (User) intent.getSerializableExtra("user");

            name.setHint(user.getName());
            email.setHint(user.getEmail());
            phone.setHint(user.getPhone().toString());
        }

        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameVal = name.getText().toString().isEmpty() ?
                        name.getHint().toString() : name.getText().toString();
                String emailVal = email.getText().toString().isEmpty() ?
                                email.getHint().toString() : email.getText().toString();
                Long phoneVal = Long.parseLong(phone.getText().toString().isEmpty() ?
                        phone.getHint().toString() : phone.getText().toString());
                User user1 = new User(nameVal, phoneVal, emailVal);
                user1.setId(user.getId());
                UserDB.getInstance(getApplicationContext()).userDAO().update(user1);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user != null)
                    UserDB.getInstance(getApplicationContext()).userDAO().delete(user);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
