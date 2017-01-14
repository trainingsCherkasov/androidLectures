package com.example.illya.studylecture12;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;


    public MyDBHelper(Context context) {
        super(context, "Student2.db", null, 1);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE " + Student.TABLE_NAME + " ( " +
                        Student.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        Student.COLUMN_FIRST_NAME + " TEXT NOT NULL, " +
                        Student.COLUMN_LAST_NAME + " TEXT NOT NULL, " +
                        Student.COLUMN_AGE + " INTEGER NOT NULL" +
                        " );"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public long insertStudent(Student student) {
        long id = -1;
        try {
            ContentValues values = new ContentValues();
            values.put(Student.COLUMN_FIRST_NAME, student.getFirstName());
            values.put(Student.COLUMN_LAST_NAME, student.getLastName());
            values.put(Student.COLUMN_AGE, student.getAge());
            id = db.insert(Student.TABLE_NAME, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("INSERT", "Inserted with id "+id);

        return id;
    }


    public ArrayList<Student> getStudents() {

        ArrayList<Student> students = new ArrayList<>();
        Cursor studentCursor = null;
        try {
            studentCursor = db.query(Student.TABLE_NAME, null, null, null, null, null, null);

            if (studentCursor.moveToFirst()) {

                while (!studentCursor.isAfterLast()) {
                    Student student = new Student();
                    long id = studentCursor.getLong(studentCursor.getColumnIndex(Student.COLUMN_ID));
                    String fistName = studentCursor.getString(studentCursor.getColumnIndex(Student.COLUMN_FIRST_NAME));
                    String lastName = studentCursor.getString(studentCursor.getColumnIndex(Student.COLUMN_LAST_NAME));
                    long age = studentCursor.getLong(studentCursor.getColumnIndex(Student.COLUMN_AGE));

                    student.setId(id);
                    student.setFirstName(fistName);
                    student.setLastName(lastName);
                    student.setAge(age);
                    students.add(student);
                    studentCursor.moveToNext();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (studentCursor != null) {
                studentCursor.close();
            }
        }

        return students;
    }


    public Student getStudent(long id) {
        Student student = new Student();
        Cursor cursor = null;


        try {
            cursor = db.query(Student.TABLE_NAME, null, Student.COLUMN_ID + " = " + id, null, null, null, null);
            if (cursor.moveToFirst()) {

                long sid = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_ID));
                String fistName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_FIRST_NAME));
                String lastName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_LAST_NAME));
                long age = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_AGE));

                student.setId(sid);
                student.setFirstName(fistName);
                student.setLastName(lastName);
                student.setAge(age);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }


        return student;
    }
}
