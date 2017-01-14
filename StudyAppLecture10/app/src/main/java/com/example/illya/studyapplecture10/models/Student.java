package com.example.illya.studyapplecture10.models;


public class Student {
    public static final String TABLE_NAME = "Students";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FIRST_NAME = "FirstName";
    public static final String COLUMN_LAST_NAME = "LastNAme";
    public static final String COLUMN_AGE = "Age";


    public String toString(){
        return String.format("id: %s, %s,%s, age: %s", id, firstName, lastName, age);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;
    private long idGroup;
    private String firstName;
    private String lastName;
    private long age;

    public Student() {

    }

    public Student(long idGroup, String firstName, String lastName, long age) {
        this.idGroup = idGroup;
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

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }


}
