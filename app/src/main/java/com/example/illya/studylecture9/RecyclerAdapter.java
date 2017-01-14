package com.example.illya.studylecture9;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private ArrayList<Student> students;
    private LayoutInflater inflater;

    private int selectedPosition = -1;


    public RecyclerAdapter(Context context, ArrayList<Student> students) {
        this.students = students;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.student_layout, parent, false);

        StudentViewHolder viewHolder = new StudentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final StudentViewHolder holder, final int position) {
         final Student student = students.get(position);
        holder.firstname.setText(student.getFirstName());
        holder.lastName.setText(student.getLastName());
        holder.age.setText(student.getAge() + "");

        if(selectedPosition == position){
            holder.radioButton.setChecked(true);
        }else{
            holder.radioButton.setChecked(false);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(student);
                }

                if(selectedPosition>-1){
                    notifyItemChanged(selectedPosition);
                }
                selectedPosition = position;
                holder.radioButton.setChecked(true);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (listener != null) {
                    listener.onLongItemLick(student);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    private OnItemClickedListener listener;

    public void setOnClickListener(OnItemClickedListener listener) {
        this.listener = listener;
    }


    public interface OnItemClickedListener {
        void onItemClick(Student student);

        void onLongItemLick(Student student);
    }
}
