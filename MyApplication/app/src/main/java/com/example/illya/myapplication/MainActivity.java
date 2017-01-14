package com.example.illya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_STUDENT = "STUDENT";

    public static final int STUDENT_UPDATE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View view) {
        Intent intent;
        StudentP student;
        switch (view.getId()) {
            case R.id.button1:
                intent = new Intent(this, Main2Activity.class);
                EditText textField = (EditText) findViewById(R.id.inputText);
                String text = textField.getText().toString();
                intent.putExtra("Text", text);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(this, StudentActivity.class);
                student = new StudentP("Ivan", "Ivanov",20);
                intent.putExtra(EXTRA_STUDENT, student);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(this, StudentUpdateActivity.class);
                student = new StudentP("Ivan", "Ivanov",20);
                intent.putExtra(EXTRA_STUDENT, student);
                startActivityForResult(intent,STUDENT_UPDATE_REQUEST);
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
            case R.id.button6:
                break;
            case R.id.button7:
                break;
            case R.id.button8:
                break;
            case R.id.button9:
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == STUDENT_UPDATE_REQUEST) {
                StudentP student = data.getParcelableExtra("RESULT");
                EditText textField = (EditText) findViewById(R.id.inputText);
                textField.setText(student.firstName + "  " +student.lastName + "  " + student.age);
            }
        }
    }
}
