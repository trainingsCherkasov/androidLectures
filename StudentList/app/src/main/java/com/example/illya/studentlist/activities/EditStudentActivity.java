package com.example.illya.studentlist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.illya.studentlist.IntentExtraCode;
import com.example.illya.studentlist.R;
import com.example.illya.studentlist.datamodel.Student;

public class EditStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_editing);
        prepareData();
    }

    private void prepareData() {
        Student student = getIntent().getParcelableExtra(IntentExtraCode.STUDENT);

        ((EditText) findViewById(R.id.firstNameEdit)).setText(student.getFirstName());
        ((EditText) findViewById(R.id.lastNameEdit)).setText(student.getLastName());
        ((EditText) findViewById(R.id.ageEdit)).setText(Integer.toString(student.getAge()));
    }

    public void saveEditedStudent(View view) {

        String firstName = ((EditText) findViewById(R.id.firstNameEdit)).getText().toString();
        String lastName = ((EditText) findViewById(R.id.lastNameEdit)).getText().toString();
        int age = Integer.parseInt(((EditText) findViewById(R.id.ageEdit)).getText().toString());

        Student origin = getIntent().getParcelableExtra(IntentExtraCode.STUDENT);

        origin.setFirstName(firstName);
        origin.setLastName(lastName);
        origin.setAge(age);
        Intent resultIntent = new Intent();
        resultIntent.putExtra(IntentExtraCode.STUDENT, origin);
        setResult(RESULT_OK, resultIntent);
        finish();


    }
}
