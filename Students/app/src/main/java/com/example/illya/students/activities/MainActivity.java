package com.example.illya.students.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.illya.students.R;
import com.example.illya.students.dataObjects.Student;
import com.example.illya.students.flags.EXTRA_FLAG;
import com.example.illya.students.flags.REQUEST;

public class MainActivity extends AppCompatActivity {
    private TextView firstNameField;
    private TextView secondNameField;
    private TextView ageField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFields();
        readStudent();
    }

    private void initFields() {
        firstNameField = (TextView) findViewById(R.id.firstNameField);
        secondNameField = (TextView) findViewById(R.id.secondNameField);
        ageField = (TextView) findViewById(R.id.ageField);
    }

    public void callUpdate(View view) {
        Intent intent = new Intent(this, StudentUpdateActivity.class);
        intent.putExtra(EXTRA_FLAG.STUDENT.getValue(), readStudent());
        startActivityForResult(intent, REQUEST.STUDENT_UPDATE.getValue());
    }

    private Student readStudent() {
        String fName = firstNameField.getText().toString();
        String sName = secondNameField.getText().toString();
        int age = Integer.parseInt((ageField).getText().toString());
        return new Student(fName, sName, age);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST.STUDENT_UPDATE.getValue()) {
                Student student = data.getParcelableExtra(EXTRA_FLAG.STUDENT.getValue());
                firstNameField.setText(student.getFirstName());
                secondNameField.setText(student.getSecondName());
                ageField.setText(student.getAge() + "");
            }
        }
    }
}
