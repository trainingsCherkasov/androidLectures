package com.example.illya.studentlist.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.illya.studentlist.R;
import com.example.illya.studentlist.datamodel.Student;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {

    public List<Student> getStudents() {
        return students;
    }

    private List<Student> students;
    private int resourceId;
    private LayoutInflater inflater;


    public StudentAdapter(Context context, int resource, List<Student> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
        this.students = objects;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(resourceId, null);
        Student student = students.get(position);

        ((TextView) convertView.findViewById(R.id.firstName)).setText(student.getFirstName());
        ((TextView) convertView.findViewById(R.id.lastName)).setText(student.getLastName());
        ((TextView) convertView.findViewById(R.id.age)).setText(Integer.toString(student.getAge()));

        return convertView;
    }


}
