package com.example.illya.students.flags;


public enum REQUEST {
    STUDENT_UPDATE(1);

    private int value;

    REQUEST(int i) {
        value = i;
    }

    public int getValue() {
        return value;
    }
}
