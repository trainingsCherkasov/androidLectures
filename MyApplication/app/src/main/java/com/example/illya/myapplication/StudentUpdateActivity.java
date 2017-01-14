package com.example.illya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class StudentUpdateActivity extends AppCompatActivity {
    private EditText first;
    private EditText second;
    private EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_update);

        Intent intent = getIntent();
        StudentP s = intent.getParcelableExtra(MainActivity.EXTRA_STUDENT);
        first = (EditText) findViewById(R.id.firstname);
        first.setText(s.firstName);

        second = (EditText) findViewById(R.id.lastname);
        second.setText(s.lastName);
        age = (EditText) findViewById(R.id.age);
        age.setText(s.age + "");
    }


    public void onClickUpdate(View view) {
        Intent intent1 = new Intent();
        StudentP studentP = new StudentP();
        studentP.firstName = first.getText().toString();
        studentP.lastName = second.getText().toString();
        studentP.age = Integer.parseInt(age.getText().toString());
        intent1.putExtra("RESULT", studentP);
        setResult(RESULT_OK, intent1);
        finish();
    }
}
