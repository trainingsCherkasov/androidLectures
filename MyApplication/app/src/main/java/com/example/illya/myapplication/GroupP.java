package com.example.illya.myapplication;


import android.os.Parcel;
import android.os.Parcelable;

public class GroupP implements Parcelable{

    private String number;
    private StudentP[] students;

    public GroupP(String number, StudentP[] students) {
        this.number = number;
        this.students = students;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.number);
        dest.writeTypedArray(this.students, flags);
    }

    public GroupP() {
    }

    protected GroupP(Parcel in) {
        this.number = in.readString();
        this.students = in.createTypedArray(StudentP.CREATOR);
    }

    public static final Creator<GroupP> CREATOR = new Creator<GroupP>() {
        @Override
        public GroupP createFromParcel(Parcel source) {
            return new GroupP(source);
        }

        @Override
        public GroupP[] newArray(int size) {
            return new GroupP[size];
        }
    };
}
