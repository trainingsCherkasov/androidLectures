package com.example.illya.studentexpandablegroup.utils;


import com.example.illya.studentexpandablegroup.models.Student;

public class StudentsGenerator {


    public static Student[] createIvanov(int amount) {
        Student[] students = new Student[amount];
        for (int i = 0; i < amount; i++) {
            String firstName = "Ivan" + i;
            String lastName = "Ivanov" + i;
            int age = 20 + i;
            Student s = new Student(firstName, lastName, age);
            students[i] = s;
        }
        return students;
    }



    public static Student[] createPetrov(int amount) {
        Student[] students = new Student[amount];
        for (int i = 0; i < amount; i++) {
            String firstName = "Petr" + i;
            String lastName = "Petrov" + i;
            int age = 20 + i;
            Student s = new Student(firstName, lastName, age);
            students[i] = s;
        }
        return students;
    }


    public static Student[] createSydorov(int amount) {
        Student[] students = new Student[amount];
        for (int i = 0; i < amount; i++) {
            String firstName = "Sydr" + i;
            String lastName = "Sydorovov" + i;
            int age = 20 + i;
            Student s = new Student(firstName, lastName, age);
            students[i] = s;
        }
        return students;
    }
}
