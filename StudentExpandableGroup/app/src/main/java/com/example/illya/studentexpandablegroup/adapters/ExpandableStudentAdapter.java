package com.example.illya.studentexpandablegroup.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.illya.studentexpandablegroup.R;
import com.example.illya.studentexpandablegroup.models.Group;
import com.example.illya.studentexpandablegroup.models.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpandableStudentAdapter extends BaseExpandableListAdapter {

    public ArrayList<Group> getGroups() {
        return groups;
    }

    private ArrayList<Group> groups;
    private LayoutInflater inflater;

    public HashMap<Integer, HashMap<Integer, Boolean>> getSelectedChilds() {
        return selectedChilds;
    }

    private HashMap<Integer,HashMap<Integer, Boolean>> selectedChilds;

    public ExpandableStudentAdapter(Context context, ArrayList<Group> groups) {
        this.groups = groups;
        this.inflater = LayoutInflater.from(context);
        selectedChilds = new HashMap<>();
        for (int i = 0; i < groups.size(); i++) {
            HashMap<Integer, Boolean> childStates = new HashMap<>();
            for (int student = 0; student < groups.get(i).getStudents().length; student++) {
                childStates.put(student, false);
            }
            selectedChilds.put(i, childStates);
        }

    }

    @Override
    public View getGroupView(int groupPoz, boolean b, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.group_main, null);
        Group group = (Group) getGroup(groupPoz);
        ((TextView) view.findViewById(R.id.groupNameMain)).setText(group.getGroupName());
        return view;
    }

    @Override
    public View getChildView(int groupPoz, int childPoz, boolean b, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.student_main, null);
        Student student = (Student) getChild(groupPoz, childPoz);

        ((TextView) view.findViewById(R.id.firstNameMain)).setText(student.getFirstName());
        ((TextView) view.findViewById(R.id.lastNameMain)).setText(student.getLastName());
        ((TextView) view.findViewById(R.id.ageMain)).setText(String.valueOf(student.getAge()));

        ((CheckBox) view.findViewById(R.id.studentMainCheckbox)).setChecked(selectedChilds.get(groupPoz).get(childPoz));
        return view;
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
    public Object getChild(int groupPoz, int childPoz) {
        return groups.get(groupPoz).getStudents()[childPoz];
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
