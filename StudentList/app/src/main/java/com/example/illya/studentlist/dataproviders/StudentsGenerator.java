package com.example.illya.studentlist.dataproviders;


import com.example.illya.studentlist.datamodel.Student;
import com.example.illya.studentlist.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentsGenerator {

    public static List<Student> createStudentsList(int amount) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < amount; i++) {

            String name = StringUtils.createRandomStringWithLength(10);
            String lastName = StringUtils.createRandomStringWithLength(10);
            int age = new Random().nextInt(13) + 18;
            students.add(new Student(name, lastName, age));
        }
        return students;
    }

}
