package com.example.illya.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
   

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText textField = (EditText) findViewById(R.id.act2text);
        Intent intent = getIntent();
        String text = intent.getStringExtra("Text");
        textField.setText(text);
    }
}
