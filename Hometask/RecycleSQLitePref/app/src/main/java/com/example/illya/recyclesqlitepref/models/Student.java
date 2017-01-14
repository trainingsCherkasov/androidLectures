package com.example.illya.recyclesqlitepref.models;


import com.google.gson.annotations.SerializedName;

public class Student {
    public static final String TABLE_NAME = "Students";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FIRST_NAME = "FirstName";
    public static final String COLUMN_LAST_NAME = "LastNAme";
    public static final String COLUMN_AGE = "Age";

    @SerializedName("FirstName")
    private String firstName;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("Age")
    private long age;
    @SerializedName("Id")
    private long id;

    public Student() {

    }

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "First name: " + firstName +
                ", Last name: " + lastName +
                ", Age: " + age;
    }
}
