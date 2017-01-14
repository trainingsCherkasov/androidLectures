package com.example.illya.recyclesqlitepref.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.illya.recyclesqlitepref.R;
import com.example.illya.recyclesqlitepref.models.Student;
import com.example.illya.recyclesqlitepref.viewHolders.StudentViewHolder;

import java.util.ArrayList;

public class StudentRecycleAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private ArrayList<Student> students;
    private LayoutInflater inflater;
    public StudentRecycleAdapter(Context context, ArrayList<Student> students) {
        this.students = students;
        inflater = LayoutInflater.from(context);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.student_row_layout, parent, false);
        StudentViewHolder viewHolder = new StudentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Student student = students.get(position);

        holder.getFirstNameView().setText(student.getFirstName());
        holder.getLastNameView().setText(student.getLastName());
        holder.getAgeView().setText(String.valueOf(student.getAge()));


    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
