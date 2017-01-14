package com.example.illya.myapplication;

import java.io.Serializable;


public class Student implements Serializable {

    public String firstName;
    public String lastName;
    public int age;

    public Student() {

    }

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


}
