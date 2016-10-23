package com.example.pustikom.adapterplay;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pustikom.adapterplay.com.example.pustikom.adapter.StudentArrayAdapter;
import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ArrayList<Student> students = new DataStudent().getList();
        StudentArrayAdapter studentArrayAdapter = new StudentArrayAdapter(this,students);
        ListView list_item = (ListView) findViewById(R.id.list_item);
        list_item.setAdapter(studentArrayAdapter);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.addFloatingButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddStudent.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Student> populateStudentDummies(){
        DataStudent dataStudent = DataStudent.getInstance();
        dataStudent.add(new Student(dataStudent.size()+1,"3145136221","KHARIZA NABILLA AULIA","08188xxxxxx","khariza.nabilla@gmail.com"));
        return dataStudent.getList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_student, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.createDummy:
                ArrayList<Student> students = populateStudentDummies();
                StudentArrayAdapter studentArrayAdapter = new StudentArrayAdapter(this,students);
                ListView list_item = (ListView) findViewById(R.id.list_item);
                list_item.setAdapter(studentArrayAdapter);
                return true;

            case R.id.clearList:
                DataStudent.getInstance().clearList();
                studentArrayAdapter = new StudentArrayAdapter(this, DataStudent.getList());
                list_item = (ListView) findViewById(R.id.list_item);
                list_item.setAdapter(studentArrayAdapter);
                studentArrayAdapter.notifyDataSetChanged();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
