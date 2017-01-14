package com.example.illya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Intent intent = getIntent();
        StudentP s = intent.getParcelableExtra(MainActivity.EXTRA_STUDENT);
        EditText first = (EditText) findViewById(R.id.firstname);
        first.setText(s.firstName);

        EditText second = (EditText) findViewById(R.id.lastname);
        second.setText(s.lastName);
        EditText age = (EditText) findViewById(R.id.age);
        age.setText(s.age+"");
    }


    public void onClickFinish(View view){
        Intent intent  = new Intent();
        intent.putExtra("RESULT","DONE");
        setResult(RESULT_OK, intent);
           finish();
    }
}
