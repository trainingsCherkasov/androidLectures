package com.example.illya.studentexpandablegroup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;

import com.example.illya.studentexpandablegroup.ExtraNames;
import com.example.illya.studentexpandablegroup.R;
import com.example.illya.studentexpandablegroup.adapters.ExpandableStudentAdapter;
import com.example.illya.studentexpandablegroup.models.Group;
import com.example.illya.studentexpandablegroup.models.Student;
import com.example.illya.studentexpandablegroup.utils.StudentsGenerator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ExpandableStudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Group> groups = new ArrayList<>();
        groups.add(new Group("Group 1", StudentsGenerator.createIvanov(10)));
        groups.add(new Group("Group 2", StudentsGenerator.createPetrov(10)));
        groups.add(new Group("Group 3", StudentsGenerator.createSydorov(10)));
        adapter = new ExpandableStudentAdapter(this, groups);


        ExpandableListView view = (ExpandableListView) findViewById(R.id.expandableStudentList);
        view.setAdapter(adapter);
        view.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPoz, int childPoz, long l) {
                CheckBox chkbox = (CheckBox) view.findViewById(R.id.studentMainCheckbox);
                if (chkbox.isChecked()) {
                    chkbox.setChecked(false);
                    adapter.getSelectedChilds().get(groupPoz).put(childPoz, false);

                } else {
                    chkbox.setChecked(true);
                    adapter.getSelectedChilds().get(groupPoz).put(childPoz, true);
                }
//                Student student = adapter.getGroups().get(groupPoz).getStudents()[childPoz];
//                Intent intent = new Intent(MainActivity.this, StudentUpdateActivity.class);
//                intent.putExtra(ExtraNames.STUDENT_EXTRA, student);
//                startActivityForResult(intent, ExtraNames.STUDENT_UPDATE_REQUEST);
                return false;
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == ExtraNames.STUDENT_UPDATE_REQUEST) {
                updateStudent(data);
            }

        }
    }

    private void updateStudent(Intent data) {
        Student updatedStudent = data.getParcelableExtra(ExtraNames.STUDENT_EXTRA);
        for (Group group : adapter.getGroups()) {
            for (int i = 0; i < group.getStudents().length; i++) {
                if (group.getStudents()[i].getId().equals(updatedStudent.getId())) {
                    group.getStudents()[i] = updatedStudent;
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}
