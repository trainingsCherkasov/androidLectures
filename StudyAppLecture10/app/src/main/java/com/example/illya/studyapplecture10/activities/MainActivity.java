package com.example.illya.studyapplecture10.activities;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.illya.studyapplecture10.R;
import com.example.illya.studyapplecture10.database.DatabaseHelper;
import com.example.illya.studyapplecture10.models.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DatabaseHelper(this);

        ArrayList<Student> students = helper.getStudents();


        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, students);

        ListView view = (ListView) findViewById(R.id.listView);
        view.setAdapter(adapter);

    }


    public void onClick(View v) {

        SQLiteDatabase db = helper.getWritableDatabase();
        switch (v.getId()) {
            case R.id.b1:
                long id = helper.insertStudent(new Student(idGroup, "Petro", "Petrov", 22));
                Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();
                break;
            case R.id.b2:
                ContentValues values2 = new ContentValues();
                values2.put(Student.COLUMN_AGE, 30);
                int count = db.update(Student.TABLE_NAME, values2, "_id=1", null);
//                int count = db.update("Students", values2, "_id=?", new String[]{"1"});
                Toast.makeText(this, "updated " + count, Toast.LENGTH_SHORT).show();
                break;
            case R.id.b3:
                break;
            case R.id.b4:
                break;
            case R.id.b5:
                break;
            case R.id.b6:
                break;
            case R.id.b7:
                break;
            case R.id.b8:
                break;
            case R.id.b9:
                break;
            case R.id.b10:
                break;
        }


    }
}
