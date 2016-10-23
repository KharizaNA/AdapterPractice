package com.example.pustikom.adapterplay;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;

public class AddStudent extends AppCompatActivity {
    EditText no, name, phone, noreg, email;
    FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        no = (EditText) findViewById(R.id.no);
        noreg = (EditText) findViewById(R.id.noreg);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.mail);

        add = (FloatingActionButton) findViewById(R.id.addFloating);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataStudent dataStudent = DataStudent.getInstance().getInstance();
                dataStudent.add(new Student(Integer.parseInt(no.getText().toString()),noreg.getText().toString(),name.getText().toString(), phone.getText().toString(),email.getText().toString()));
                Intent intent = new Intent(getBaseContext(), StudentActivity.class);
                startActivity(intent);
            }
        });

    }
}
