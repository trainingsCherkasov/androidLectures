package com.example.illya.recyclesqlitepref.viewHolders;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.illya.recyclesqlitepref.R;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    private TextView firstNameView;
    private TextView lastNameView;
    private TextView ageView;

    public StudentViewHolder(View itemView) {
        super(itemView);
        firstNameView = (TextView) itemView.findViewById(R.id.firstName);
        lastNameView = (TextView) itemView.findViewById(R.id.lastName);
        ageView = (TextView) itemView.findViewById(R.id.age);
    }

    public TextView getFirstNameView() {
        return firstNameView;
    }

    public void setFirstNameView(TextView firstNameView) {
        this.firstNameView = firstNameView;
    }

    public TextView getLastNameView() {
        return lastNameView;
    }

    public void setLastNameView(TextView lastNameView) {
        this.lastNameView = lastNameView;
    }

    public TextView getAgeView() {
        return ageView;
    }

    public void setAgeView(TextView ageView) {
        this.ageView = ageView;
    }
}
