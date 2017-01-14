package com.example.illya.recyclesqlitepref.touchHelpers;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.illya.recyclesqlitepref.adapters.StudentRecycleAdapter;
import com.example.illya.recyclesqlitepref.models.Student;

public class StudentTouchHelper extends ItemTouchHelper.SimpleCallback {
    private StudentRecycleAdapter adapter;

    public StudentTouchHelper(StudentRecycleAdapter adapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT);
        this.adapter = adapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromPos = viewHolder.getAdapterPosition();
        int toPos = target.getAdapterPosition();
        Student student = adapter.getStudents().get(fromPos);
        adapter.getStudents().remove(fromPos);
        adapter.getStudents().add(toPos, student);
        adapter.notifyItemMoved(fromPos, toPos);
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int fromPos = viewHolder.getAdapterPosition();
        adapter.getStudents().remove(fromPos);
        adapter.notifyItemRemoved(fromPos);

    }
}
