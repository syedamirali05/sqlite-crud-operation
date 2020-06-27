package com.blogspot.codeentity.crudsqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ModTeacher extends AppCompatActivity {

    private ListView listView;
    private ArrayList<TeachersModel> teachersModelArrayList;
    private CustomMod customMod;
    private DatabaseHelperTeacher databaseHelperTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_teacher);

        listView = (ListView) findViewById(R.id.teachers_lvi);

        databaseHelperTeacher = new DatabaseHelperTeacher(this);

        teachersModelArrayList = databaseHelperTeacher.getAllTeachers();

        customMod = new CustomMod(this,teachersModelArrayList);
        listView.setAdapter(customMod);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ModTeacher.this,ModifyTeachersActivity.class);
                intent.putExtra("teachers",teachersModelArrayList.get(position));
                startActivity(intent);
            }
        });
    }
}
