package com.mobdeve.s11.lima.alfonso.formetiveexercise4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    DatabaseHelper accountsDB;

    Button btnSubmit;
    EditText etUname, etName, etDesc;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        accountsDB = new DatabaseHelper(this);

        btnSubmit = findViewById(R.id.btn_create);

        etUname = findViewById(R.id.et_username);
        etName = findViewById(R.id.et_name);
        etDesc = findViewById(R.id.et_description);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUname.getText().toString();
                String name = etName.getText().toString();
                String desc = etDesc.getText().toString();

                boolean insertData = accountsDB.addData(username,name,desc);

                if(insertData == true) {
                    Toast.makeText(AddActivity.this,"DATA ADDED!!",Toast.LENGTH_LONG).show();
                    Log.e("HELLO","WORKSS");
                }
                else {
                    Toast.makeText(AddActivity.this,"DATA NOT ADDED!!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
