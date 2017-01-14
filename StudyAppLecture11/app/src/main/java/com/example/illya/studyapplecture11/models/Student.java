package com.example.illya.studyapplecture11.models;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Student {

    @Element(name = "firstName")
    private String firstName;
    @Element(name = "SeconName")
    private String lastName;
    @Element(name = "Age")
    private int age;


    public Student() {

    }

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
