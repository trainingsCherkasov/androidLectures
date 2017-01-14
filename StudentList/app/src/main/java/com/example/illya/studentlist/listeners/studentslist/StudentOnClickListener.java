package com.example.illya.studentlist.listeners.studentslist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.illya.studentlist.IntentCode;
import com.example.illya.studentlist.IntentExtraCode;
import com.example.illya.studentlist.activities.EditStudentActivity;
import com.example.illya.studentlist.adapters.StudentAdapter;
import com.example.illya.studentlist.datamodel.Student;


public class StudentOnClickListener {

    public static class OnItemClick implements ListView.OnItemClickListener {
        private Context context;

        public OnItemClick(Context context) {
            this.context = context;
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Student student = ((StudentAdapter) adapterView.getAdapter()).getStudents().get(i);
            Intent editStudentIntent = new Intent(context, EditStudentActivity.class);
            editStudentIntent.putExtra(IntentExtraCode.STUDENT, student);
            ((AppCompatActivity) context).startActivityForResult(editStudentIntent, IntentCode.EDIT_STUDENT);
        }
    }


}
