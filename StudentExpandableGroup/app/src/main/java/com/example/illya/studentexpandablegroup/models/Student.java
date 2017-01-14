package com.example.illya.studentexpandablegroup.models;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class Student implements Parcelable {

    private String firstName;
    private String lastName;
    private int age;

    public String getId() {
        return id;
    }

    private String id;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = UUID.randomUUID().toString();
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeInt(this.age);
        dest.writeString(this.id);
    }

    protected Student(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.age = in.readInt();
        this.id = in.readString();

    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
