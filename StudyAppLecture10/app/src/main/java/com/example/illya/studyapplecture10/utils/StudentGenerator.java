package com.example.illya.studyapplecture10.utils;


import com.example.illya.studyapplecture10.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentGenerator {

    private static String[] firstNames = {"Ivan", "Petr", "Sydr", "Serhei", "John", "Vadym", "Alex", "Max"};
    private static String[] lastNames = {"Ivanov", "Petrov", "Sydrov", "Serheiv", "Johnich", "Vadymych", "Alexeev", "Maximov"};


    private static String getRandomName() {
        return firstNames[new Random().nextInt(firstNames.length)];
    }

    private static String getRandomLastName() {
        return lastNames[new Random().nextInt(lastNames.length)];
    }


    private static long getRandomAge() {
        Random ran = new Random();
        return ran.nextInt(10) + 20;
    }

    public static Student getRandomStudent() {
        return new Student(idGroup, getRandomName(), getRandomLastName(), getRandomAge());
    }

    public static Student[] getArrayOfStudents(int amount) {
        Student[] students = new Student[amount];
        for (int i = 0; i < amount; i++) {
            students[i] = getRandomStudent();
        }
        return students;
    }

    public static List<Student> getListOfStudents(int amount) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            students.add(getRandomStudent());
        }
        return students;


    }

}
