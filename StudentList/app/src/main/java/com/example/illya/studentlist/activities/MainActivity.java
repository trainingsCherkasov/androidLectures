package com.example.illya.studentlist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.illya.studentlist.IntentExtraCode;
import com.example.illya.studentlist.R;
import com.example.illya.studentlist.adapters.StudentAdapter;
import com.example.illya.studentlist.datamodel.Student;
import com.example.illya.studentlist.dataproviders.StudentsGenerator;
import com.example.illya.studentlist.listeners.studentslist.StudentOnClickListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentAdapter studentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Student> studentsList = StudentsGenerator.createStudentsList(10);
        studentsAdapter = new StudentAdapter(this, R.layout.student_adapter_view, studentsList);
        ListView view = (ListView) findViewById(R.id.studentsListView);
        view.setAdapter(studentsAdapter);
        view.setOnItemClickListener(new StudentOnClickListener.OnItemClick(this));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Student updatedStudent = data.getParcelableExtra(IntentExtraCode.STUDENT);
        List<Student> originStudents = studentsAdapter.getStudents();

        String id = updatedStudent.getID();
        for (int i = 0; i < originStudents.size(); i++) {
            if (originStudents.get(i).getID().equals(id)) {
                originStudents.set(i, updatedStudent);
                studentsAdapter.notifyDataSetChanged();
                break;
            }
        }

    }
}
