package com.example.illya.studyapplecture8;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, "click "+i,Toast.LENGTH_LONG).show();
//            }
//        });
//
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Toast.makeText(MainActivity.this, "long click "+i,Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });

//        String[] arr = new String[]{"a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n"};
//
//        ArrayAdapter adapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_multiple_choice,
//                android.R.id.text1,
//                arr
//        );


     //   final ListView listView = (ListView) findViewById(R.id.listView);
  //   listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

//        StudentArrayAdapter adapter = getStudentArrayAdapter();
//        listView.setAdapter(adapter);


//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                String text = "";
//                SparseBooleanArray res = listView.getCheckedItemPositions();
//
//                for (int i = 0; i < res.size(); i++) {
//                    if (res.get(i)) {
//                        text += i;
//                    }
//                }
//
//
//                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
//            }
//        });

//        addListenerForDelete(adapter);

//


        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setAdapter(getStudentArrayAdapter());


    }

    private void addListenerForDelete(StudentArrayAdapter adapter) {
        adapter.setStudentListener(new StudentArrayAdapter.StudentListener() {
            @Override
            public void onDelete(Student student) {
                Toast.makeText(MainActivity.this, "!!!!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @NonNull
    private StudentArrayAdapter getStudentArrayAdapter() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Ivan", "Ivanov", 20));
        list.add(new Student("Ivan1", "Ivanov1", 21));
        list.add(new Student("Ivan2", "Ivanov2", 22));
        list.add(new Student("Ivan3", "Ivanov3", 23));
        list.add(new Student("Ivan4", "Ivanov4", 24));

        return new StudentArrayAdapter(this, R.layout.student, list);
    }

    @NonNull
    private ArrayAdapter<Student> getArrayAdapterWithStudents() {
        Student[] arr = new Student[]{
                new Student("Ivan", "Ivanov", 20),
                new Student("Ivan1", "Ivanov1", 21),
                new Student("Ivan2", "Ivanov2", 22),
                new Student("Ivan3", "Ivanov3", 23)
        };
        return new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                arr
        );
    }

    @NonNull
    private ArrayAdapter<String> getArrayAdapter() {
        String[] arr = new String[]{"a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n"};

        return new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                arr
        );
    }

    public SimpleAdapter getSimpleAdapter() {
        ArrayList<HashMap<String, String>> students = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            HashMap<String, String> student = new HashMap<>();
            student.put("Name", "Ivan" + i);
            student.put("LastName", "Ivanov" + i);
            student.put("Age", String.valueOf(20 + i));
            students.add(student);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                students,
                R.layout.student,
                new String[]{"Name", "LastName", "Age"},
                new int[]{R.id.textViewFirstName, R.id.textViewLastName, R.id.textViewAge}
        );
        return adapter;
    }


}
