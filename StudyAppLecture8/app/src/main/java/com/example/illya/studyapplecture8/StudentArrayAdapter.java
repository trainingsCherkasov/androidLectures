package com.example.illya.studyapplecture8;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentArrayAdapter extends ArrayAdapter<Student> {
    private int resourceID;
    private List<Student> students;
    private LayoutInflater inflater;
    private StudentListener mListener;

    private int selectedPosition = -1;


    public StudentArrayAdapter(Context context, int resource, List<Student> objects) {
        super(context, resource, objects);
        this.resourceID = resource;
        this.students = objects;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(resourceID, null);

        final Student student = students.get(position);

        ((TextView) convertView.findViewById(R.id.textViewFirstName)).setText(student.getFirstName());
        ((TextView) convertView.findViewById(R.id.textViewLastName)).setText(student.getLastName());
        ((TextView) convertView.findViewById(R.id.textViewAge)).setText(student.getAge() + "");

//        final RadioButton rButton = (RadioButton) convertView.findViewById(R.id.radio);
//
//        rButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                selectedPosition = position;
//                notifyDataSetChanged();
//            }
//        });
//
//        if(selectedPosition == position){
//            rButton.setChecked(true);
//        }


//        convertView.findViewById(R.id.buttonDelete).setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                if(mListener != null){
//                    mListener.onDelete(student);
//                }
//            }
//        });

        return convertView;
    }


    public void setStudentListener(StudentListener listener) {
        mListener = listener;
    }


    public interface StudentListener {
        void onDelete(Student student);
    }


    @Override
    public View getDropDownView(final int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(resourceID, null);

        final Student student = students.get(position);

        ((TextView) convertView.findViewById(R.id.textViewFirstName)).setText(student.getFirstName());
        ((TextView) convertView.findViewById(R.id.textViewLastName)).setText(student.getLastName());
        ((TextView) convertView.findViewById(R.id.textViewAge)).setText(student.getAge() + "");
        return convertView;
    }
}
