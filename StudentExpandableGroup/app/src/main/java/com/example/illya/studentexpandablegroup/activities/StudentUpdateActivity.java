package com.example.illya.studentexpandablegroup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.illya.studentexpandablegroup.ExtraNames;
import com.example.illya.studentexpandablegroup.R;
import com.example.illya.studentexpandablegroup.models.Student;

public class StudentUpdateActivity extends AppCompatActivity {
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_update_layout);
        Intent intent = getIntent();
        student = intent.getParcelableExtra(ExtraNames.STUDENT_EXTRA);
        ((EditText) findViewById(R.id.firstNameUpd)).setText(student.getFirstName());
        ((EditText) findViewById(R.id.lastNameUpd)).setText(student.getLastName());
        ((EditText) findViewById(R.id.ageUpd)).setText(String.valueOf(student.getAge()));
    }


    public void saveUpdatedStudent(View view) {
        String firstName = ((EditText) findViewById(R.id.firstNameUpd)).getText().toString();
        String lastName = ((EditText) findViewById(R.id.lastNameUpd)).getText().toString();
        int age = Integer.parseInt(((EditText) findViewById(R.id.ageUpd)).getText().toString());

        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);

        Intent intent = new Intent();
        intent.putExtra(ExtraNames.STUDENT_EXTRA, student);
        setResult(RESULT_OK, intent);
        finish();
    }


    public void dismissChanges(View view){
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
