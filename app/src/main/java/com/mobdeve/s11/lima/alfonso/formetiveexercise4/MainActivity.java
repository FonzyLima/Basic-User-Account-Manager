package com.mobdeve.s11.lima.alfonso.formetiveexercise4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvUsers;
    private TextView noUsers;
    private RecyclerView.LayoutManager myManager;
    private UsersAdapter usersAdapter;
    private ArrayList<Users> usersArrayList;

    DatabaseHelper usersDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usersDB = new DatabaseHelper(this);

        FloatingActionButton fabAdd = findViewById(R.id.fab_add);
        noUsers = findViewById(R.id.tv_message);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);

                startActivity(intent);
            }
        });
        initRecyclerView();

    }

    @Override
    protected void onStart() {
        super.onStart();
        initRecyclerView();
    }

    private void initRecyclerView(){
        this.rvUsers = findViewById(R.id.rv_users);

        this.myManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        this.rvUsers.setLayoutManager(this.myManager);

        this.usersArrayList = usersDB.loadData();


        if(usersArrayList.size() == 0 || usersArrayList.isEmpty()){
            noUsers.setVisibility(View.VISIBLE);
            rvUsers.setVisibility(View.INVISIBLE);
        }
        else {
            noUsers.setVisibility(View.INVISIBLE);
            rvUsers.setVisibility(View.VISIBLE);
        }
        this.usersAdapter = new UsersAdapter(this.usersArrayList);
        this.rvUsers.setAdapter(this.usersAdapter);
    }
}