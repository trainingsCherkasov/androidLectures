package com.example.illya.studylecture9;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ExpandableStudentAdapter extends BaseExpandableListAdapter {

    private Context context1;
    private ArrayList<Group> groups;
    private LayoutInflater inflater;

    public ExpandableStudentAdapter(Context context, ArrayList<Group> groups) {
        this.context1 = context;
        this.groups = groups;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return groups.get(i).getStudents().length;
    }

    @Override
    public Object getGroup(int i) {

        return groups.get(i);
    }

    @Override
    public View getGroupView(int groupPosition, boolean expanded, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.group_layout, null);

        View indicator = view.findViewById(R.id.indicator);
        if (expanded) {
            indicator.setBackgroundColor(Color.GREEN);
        } else {
            indicator.setBackgroundColor(Color.RED);
        }

        Group group = (Group) getGroup(groupPosition);

        ((TextView) view.findViewById(R.id.group)).setText(group.getNumber());
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.student_layout, null);
        Student student = (Student) getChild(groupPosition, childPosition);

        ((TextView) view.findViewById(R.id.firstName)).setText(student.getFirstName());
        ((TextView) view.findViewById(R.id.lastName)).setText(student.getLastName());
        ((TextView) view.findViewById(R.id.age)).setText(student.getAge() + "");

        return view;
    }

    @Override
    public Object getChild(int i, int i1) {
        return groups.get(i).getStudents()[i1];
    }

    //UNUSED


    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }


    @Override
    public boolean hasStableIds() {
        return false;
    }
}
