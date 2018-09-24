package com.example.app.roomjava;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.app.roomjava.Room.User;
import com.example.app.roomjava.Room.UserDB;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<User> users = null;
    UserDB userDB;
    ArrayAdapter<User> userArrayAdapter;
    FloatingActionButton addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDB = UserDB.getInstance(this);
        users = userDB.userDAO().getAllUsers();

        userArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,users);

        listView = findViewById(R.id.user_list);
        listView.setAdapter(userArrayAdapter);

        listView.setEmptyView(findViewById(R.id.empty_list));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user =users.get(i);
                Intent intent = new Intent(getApplicationContext(),ViewUser.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });

        addButton = findViewById(R.id.addUserFloatButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddUser.class));
            }
        });

    }
}
