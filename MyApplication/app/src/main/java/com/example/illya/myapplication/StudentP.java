package com.example.illya.myapplication;


import android.os.Parcel;
import android.os.Parcelable;

public class StudentP implements Parcelable{

    public String firstName;
    public String lastName;
    public int age;

    public StudentP() {

    }

    public StudentP(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    @Override
    public String toString() {
        return "StudentP{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
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
    }

    protected StudentP(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.age = in.readInt();
    }

    public static final Creator<StudentP> CREATOR = new Creator<StudentP>() {
        @Override
        public StudentP createFromParcel(Parcel source) {
            return new StudentP(source);
        }

        @Override
        public StudentP[] newArray(int size) {
            return new StudentP[size];
        }
    };
}
