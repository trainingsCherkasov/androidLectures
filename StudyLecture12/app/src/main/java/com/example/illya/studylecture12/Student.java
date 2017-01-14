package com.example.illya.studylecture12;


import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {

    public static final String TABLE_NAME = "Students";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FIRST_NAME = "FirstNAme";
    public static final String COLUMN_LAST_NAME = "LastName";
    public static final String COLUMN_AGE = "Age";
    private long id;
    private String firstName;
    private String lastName;
    private long age;


    public Student() {

    }

    public Student(String firstName, String lastName, long age) {
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeLong(this.age);
    }

    protected Student(Parcel in) {
        this.id = in.readLong();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.age = in.readLong();
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

    @Override
    public String toString() {
        return "first Name: " +firstName + ", last name: "+lastName+ ", age: "+age;
    }
}
