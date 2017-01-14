package com.example.illya.studylecture9;



public class Group {

    private String number;
    private Student[] students;

    public Group(){

    }

    public Group(String number, Student[] students) {
        this.number = number;
        this.students = students;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
