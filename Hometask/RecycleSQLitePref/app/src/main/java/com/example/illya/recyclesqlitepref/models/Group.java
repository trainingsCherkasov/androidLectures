package com.example.illya.recyclesqlitepref.models;


public class Group {

    private int number;
    private Student[] students;


    public Group(int number, Student[] students) {
        this.number = number;
        this.students = students;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

}
