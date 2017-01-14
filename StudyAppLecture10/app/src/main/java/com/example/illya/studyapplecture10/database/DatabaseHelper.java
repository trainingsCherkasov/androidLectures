package com.example.illya.studyapplecture10.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.illya.studyapplecture10.models.Student;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;


    public DatabaseHelper(Context context) {
        super(context, "MyDB.db", null, 1);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Student.TABLE_NAME + " ("
                + Student.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Student.COLUMN_FIRST_NAME + " TEXT NOT NULL,"
                + Student.COLUMN_LAST_NAME + " TEXT NOT NULL,"
                + Student.COLUMN_AGE + " INTEGER NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }


    public long insertStudent(Student student) {
        long id = 0;
        try {
            ContentValues values = new ContentValues();
            values.put(Student.COLUMN_FIRST_NAME, student.getFirstName());
            values.put(Student.COLUMN_LAST_NAME, student.getLastName());
            values.put(Student.COLUMN_AGE, student.getAge());
            id = db.insert(Student.TABLE_NAME, null, values);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }


    public int updateStudent(Student student) {
        int count = 0;
        try {
            ContentValues values = new ContentValues();
            values.put(Student.COLUMN_FIRST_NAME, student.getFirstName());
            values.put(Student.COLUMN_LAST_NAME, student.getLastName());
            values.put(Student.COLUMN_AGE, student.getAge());
            count = db.update(Student.TABLE_NAME, values, Student.COLUMN_ID + "=" + student.getId(), null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }


    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = db.query(Student.TABLE_NAME, null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    Student student = new Student();
                    long id = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_ID));
                    String firstName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_FIRST_NAME));
                    String lastName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_LAST_NAME));
                    long age = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_AGE));
                    student.setId(id);
                    student.setFirstName(firstName);
                    student.setLastName(lastName);
                    student.setAge(age);
                    students.add(student);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return students;
    }
}
