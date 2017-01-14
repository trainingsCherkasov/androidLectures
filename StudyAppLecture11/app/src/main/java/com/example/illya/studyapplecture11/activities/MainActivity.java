package com.example.illya.studyapplecture11.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.illya.studyapplecture11.R;
import com.example.illya.studyapplecture11.models.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void onClick(View view) {
        SharedPreferences preferences = null;
        SharedPreferences.Editor editor = null;
        switch (view.getId()) {
            case R.id.button1:
                preferences = getPreferences(MODE_PRIVATE);
                editor = preferences.edit();
                editor.putString("Text", "I am preference");
                editor.commit();
                break;
            case R.id.button2:
                preferences = getPreferences(MODE_PRIVATE);
                Toast.makeText(this, preferences.getString("Text", "NO SUCH VALUE"), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                preferences = PreferenceManager.getDefaultSharedPreferences(this);
                Toast.makeText(this, preferences.getString("edit_text_preference_1", ""), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5:
                saveInternalFile("MyFile.txt", "I am file data");
                break;
            case R.id.button6:
                Toast.makeText(this, readInternalFile("MyFile.txt"), Toast.LENGTH_SHORT).show();
                break;

            case R.id.button7:
                if (checkAndroidMPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    if (Environment.getExternalStorageState()
                            .equals(Environment.MEDIA_MOUNTED)) {
                        File folder = Environment.getExternalStorageDirectory();
                        folder = new File(folder.getAbsoluteFile() + "/MyFolder");
                        if (!folder.exists()) {
                            folder.mkdirs();
                        }
                        saveExternalFile(folder, "MyText.txt", "Some text is here");

                    }
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        String[] permissions = {
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE
                        };
                        requestPermissions(permissions, 0);
                    }

                }
                break;
            case R.id.button8:
                if (checkAndroidMPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        File folder = Environment.getExternalStorageDirectory();
                        folder = new File(folder.getAbsoluteFile() + "/MyFolder");
                        if (folder.exists()) {
                            Toast.makeText(this, folder.getAbsolutePath(), Toast.LENGTH_SHORT).show();

//                            Toast.makeText(this, readExternalFile(folder, "MyText.txt"), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "NO text", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(this, "NO SD CARD", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.button9:
                Student student = new Student("Ivan", "Ivanov", 22);
                Gson gson = new GsonBuilder().create();
                String json = gson.toJson(student);
                saveInternalFile("Student.txt", json);

                break;
            case R.id.button10:
                String json2 = readInternalFile("Student.txt");
                Gson gson1 = new GsonBuilder().create();
                Student student2 = gson1.fromJson(json2, Student.class);
                Toast.makeText(this, student2.toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button11:

                try {
                    Student student2xml = new Student("Ivan", "Ivanov", 22);
                    Serializer serializer = new Persister();
                    File file = new File(getFilesDir() + "/student.xml");
                    serializer.write(student2xml, file);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                break;
            case R.id.button12:


                try {
                    Serializer serializer = new Persister();
                    File source = new File(getFilesDir() + "/student.xml");
                    Student result = serializer.read(Student.class, source);
                    Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;


        }
    }

    private void requestAndroidMPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = {
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            };
            requestPermissions(permissions, 0);
        }

    }

    private boolean checkAndroidMPermission(String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return ContextCompat.checkSelfPermission(this, permission) ==
                    PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    private void saveInternalFile(String fileName, String data) {
        try {
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    openFileOutput(fileName, Context.MODE_PRIVATE)));
            writer.write(data);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String readInternalFile(String fileName) {

        try {
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
            return builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

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


    private String readExternalFile(File folder, String fileName) {
        File file = new File(folder, fileName);
        try {
            if (file.exists()) { //Подключение к файлу
                StringBuilder builder = new StringBuilder();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;

                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                reader.close(); //Закрытие потока
                return builder.toString(); //Получение результата
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
