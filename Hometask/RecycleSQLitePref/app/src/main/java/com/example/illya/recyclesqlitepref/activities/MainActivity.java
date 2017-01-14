package com.example.illya.recyclesqlitepref.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.illya.recyclesqlitepref.PermissionSets;
import com.example.illya.recyclesqlitepref.R;
import com.example.illya.recyclesqlitepref.adapters.StudentRecycleAdapter;
import com.example.illya.recyclesqlitepref.database.StudentDataBaseHelper;
import com.example.illya.recyclesqlitepref.models.Student;
import com.example.illya.recyclesqlitepref.touchHelpers.StudentTouchHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private StudentDataBaseHelper dbHelper;
    private StudentRecycleAdapter adapter;
    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(PermissionSets.EXTERNAL_STORAGE_ACCESS, 0);
        }
        setContentView(R.layout.activity_main);
        dbHelper = new StudentDataBaseHelper(this);
        students = getStudents();
        adapter = new StudentRecycleAdapter(this, students);

        RecyclerView view = (RecyclerView) findViewById(R.id.studentsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        view.setLayoutManager(layoutManager);
        view.setAdapter(adapter);

        ItemTouchHelper touchHelper = new ItemTouchHelper(new StudentTouchHelper(adapter));
        touchHelper.attachToRecyclerView(view);
    }


    private ArrayList<Student> getStudents() {
        ArrayList<Student> students = dbHelper.getStudents();
        if (students.size() == 0) {
            for (int i = 0; i < 50; i++) {
                int randomNum = new Random().nextInt(25) + 16;
                Student student = new Student("Petr_" + i, "Ivanov_" + i, randomNum);
                dbHelper.insertStudent(student);
            }
            students = dbHelper.getStudents();
        }
        return students;
    }

    public void onSaveClick(View v) {


        switch (v.getId()) {
            case R.id.saveToDB:
                Toast.makeText(this, adapter.getStudents().size()+"", Toast.LENGTH_SHORT).show();
                //TODO not yet implemented
                break;
            case R.id.saveToFile:

                doJob();
                break;
        }
    }

    private void doJob() {
        if (checkAndroidMPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            if (Environment.getExternalStorageState()
                    .equals(Environment.MEDIA_MOUNTED)) {
                File folder = Environment.getExternalStorageDirectory();
                folder = new File(folder.getAbsoluteFile() + "/Students");
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                String studentsJson = new GsonBuilder().create().toJson(students);
                Log.d("Students: ", studentsJson);
                saveExternalFile(folder, "Students.json", studentsJson);
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(PermissionSets.EXTERNAL_STORAGE_ACCESS, 0);
            }

        }
    }

    private boolean checkAndroidMPermission(String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return ContextCompat.checkSelfPermission(this, permission) ==
                    PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    private void saveExternalFile(File folder, String fileName, String data) {
        File file = new File(folder, fileName);

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
            writer.write(data);
            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
