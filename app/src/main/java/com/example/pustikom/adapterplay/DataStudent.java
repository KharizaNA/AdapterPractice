package com.example.pustikom.adapterplay;

import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;

import java.util.ArrayList;

public class DataStudent {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static DataStudent instance = new DataStudent();

    public static DataStudent getInstance(){
        return instance;
    }

    public static ArrayList<Student> getList(){
        return studentList;
    }

    public void clearList(){
        studentList.clear();
    }
    public int size(){
        return studentList.size();
    }
    public void add(Student student){
        studentList.add(student);
    }
}
