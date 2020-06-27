package com.blogspot.codeentity.crudsqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addTeachers;
    Button modTeachers;
    private ListView listView;
    private ArrayList<TeachersModel> teachersModelArrayList;
    private CustomAdapterTeacher customAdapterTeacher;
    private DatabaseHelperTeacher databaseHelperTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTeachersActivity();
        modTeachersActivity();

        listView = (ListView) findViewById(R.id.teachers_lv);

        databaseHelperTeacher = new DatabaseHelperTeacher(this);

        teachersModelArrayList = databaseHelperTeacher.getAllTeachers();

        customAdapterTeacher = new CustomAdapterTeacher(this,teachersModelArrayList);
        listView.setAdapter(customAdapterTeacher);
    }

    public  void addTeachersActivity(){
        addTeachers= (Button)findViewById(R.id.btn_add_teacher);
        addTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addTeachers = new Intent(MainActivity.this, AddCourseTeacher.class);
                startActivity(addTeachers);

            }
        });
    }
    public  void modTeachersActivity(){
        modTeachers= (Button)findViewById(R.id.btn_teacher_modify);
        modTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modTeachersr = new Intent(MainActivity.this, ModTeacher.class);
                startActivity(modTeachersr);

            }
        });
    }



}
