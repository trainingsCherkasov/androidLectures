package com.example.illya.students.flags;


public enum EXTRA_FLAG {
    STUDENT("com.example.illya.students.STUDENT_FLAG");
    private String flag;


    EXTRA_FLAG(String flag) {
        this.flag = flag;
    }

    public String getValue() {
        return flag;
    }

}
