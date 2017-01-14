package com.example.illya.students.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.illya.students.R;
import com.example.illya.students.dataObjects.Student;
import com.example.illya.students.flags.EXTRA_FLAG;

public class StudentUpdateActivity extends AppCompatActivity {
    private EditText fistNameField;
    private EditText secondNameField;
    private EditText ageField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_update);
        readFields();

        Intent intent = getIntent();
        Student student = intent.getParcelableExtra(EXTRA_FLAG.STUDENT.getValue());
        setFields(student);

    }

    private void readFields() {
        fistNameField = (EditText) findViewById(R.id.firstNameUpdateField);
        secondNameField = (EditText) findViewById(R.id.secondNameUpdateField);
        ageField = (EditText) findViewById(R.id.ageUpdateField);
    }

    private void setFields(Student student) {
        fistNameField.setText(student.getFirstName());
        secondNameField.setText(student.getSecondName());
        ageField.setText(student.getAge() + "");
    }

    public void callSave(View view) {
        String firstName = fistNameField.getText().toString();
        String secondName = secondNameField.getText().toString();
        int age = Integer.parseInt(ageField.getText().toString());
        Student updatedStudent = new Student(firstName, secondName, age);

        Intent returnIntent = new Intent();
        returnIntent.putExtra(EXTRA_FLAG.STUDENT.getValue(), updatedStudent);
        setResult(RESULT_OK, returnIntent);
        finish();


    }
}
