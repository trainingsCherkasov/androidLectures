package com.example.illya.studylecture9;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;


public class StudentViewHolder extends RecyclerView.ViewHolder {
    public TextView firstname;
    public TextView lastName;
    public TextView age;
    public RadioButton radioButton;

    public StudentViewHolder(View itemView) {
        super(itemView);

        firstname = (TextView) itemView.findViewById(R.id.firstName);
        lastName = (TextView) itemView.findViewById(R.id.lastName);
        age = (TextView) itemView.findViewById(R.id.age);
        radioButton = (RadioButton) itemView.findViewById(R.id.radioButton);

    }
}
