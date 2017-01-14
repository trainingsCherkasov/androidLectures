package com.example.illya.studylecture9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            Student s1 = new Student("Ivan"+i, "Ivanov"+i, 20+i);
            students.add(s1);
        }




        RecyclerAdapter adapter = new RecyclerAdapter(this, students);
        adapter.setOnClickListener(new RecyclerAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(Student student) {
                Toast.makeText(MainActivity.this,student.getFirstName(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemLick(Student student) {
                Toast.makeText(MainActivity.this,student.getLastName(),Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);









        view.setLayoutManager(layoutManager);
        view.setAdapter(adapter);


    }

//    private void expandableStudent() {
//        Student s1 = new Student("Ivan1", "Ivanov1", 21);
//        Student s2 = new Student("Ivan2", "Ivanov2", 22);
//        Student s3 = new Student("Ivan3", "Ivanov3", 23);
//        Student s4 = new Student("Ivan4", "Ivanov4", 24);
//        Student s5 = new Student("Ivan5", "Ivanov5", 25);
//        Student s6 = new Student("Ivan6", "Ivanov6", 26);
//        Student s7 = new Student("Ivan7", "Ivanov7", 27);
//
//
//        ArrayList<Group> groups = new ArrayList<>();
//        groups.add(new Group("Group 1", new Student[] {s1,s2,s3}));
//        groups.add(new Group("Group 2", new Student[]{}));
//        groups.add(new Group("Group 3", new Student[]{s4,s5,s6,s7}));
//        ExpandableStudentAdapter adapter = new ExpandableStudentAdapter(this, groups);
//
//
//        ExpandableListView view =(ExpandableListView ) findViewById(R.id.expandebleList);
//
//        view.setAdapter(adapter);
//    }

//    private void groupListeners(ExpandableListView view) {
//        view.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
//                return false;
//            }
//        });
//
//        view.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int i) {
//
//            }
//        });
//    }

//    private void simpleExpandableadapter() {
//        ArrayList<HashMap<String, String>> groups = new ArrayList<>();
//
//        HashMap<String, String> group1 = new HashMap<>();
//        group1.put("Number", "Group 1");
//        groups.add(group1);
//
//
//        HashMap<String, String> group2 = new HashMap<>();
//        group2.put("Number", "Group 2");
//        groups.add(group2);
//
//
//        HashMap<String, String> group3 = new HashMap<>();
//        group3.put("Number", "Group 3");
//        groups.add(group3);
//
//        ArrayList<ArrayList<HashMap<String, String>>> allChilds = new ArrayList<>();
//
//        //group1 childs
//        ArrayList<HashMap<String, String>> childs1 = new ArrayList<>();
//        HashMap<String, String> child1 = new HashMap<>();
//        child1.put("Name", "Ivan");
//        childs1.add(child1);
//
//        allChilds.add(childs1);
//
//        //group2 childs
//        ArrayList<HashMap<String, String>> childs2 = new ArrayList<>();
//        HashMap<String, String> child2 = new HashMap<>();
//        child2.put("Name", "Ivan2-1");
//        childs2.add(child2);
//
//        HashMap<String, String> child22 = new HashMap<>();
//        child22.put("Name", "Ivan2-2");
//        childs2.add(child22);
//
//        allChilds.add(childs2);
//
//        //group3 childs
//        ArrayList<HashMap<String, String>> childs3 = new ArrayList<>();
//        allChilds.add(childs3);
//
//
//        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
//                this,
//                groups,
//                android.R.layout.simple_expandable_list_item_1,
//                new String[]{"Number"},
//                new int[] {android.R.id.text1},
//                allChilds,
//                android.R.layout.simple_list_item_1,
//                new String[]{"Name"},
//                new int[]{android.R.id.text1}
//        );
//
//        ExpandableListView view = (ExpandableListView) findViewById(R.id.expandebleList);
//        view.setAdapter(adapter);
//    }
//
//    private void gridview() {
//        String[] arr = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1,
//                arr);
//
////        GridView view = (GridView) findViewById(R.id.expandebleList);
////        view.setAdapter(adapter);
//    }
}
