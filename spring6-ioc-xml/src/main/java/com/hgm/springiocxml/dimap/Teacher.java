package com.hgm.springiocxml.dimap;

public class Teacher {

    private String teacherId;
    private String teacherName;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }



    @Override
    public String toString() {
        return "Student{" +
                "teacherId='" + teacherId + '\'' +
                ", TeacherName='" + teacherName + '\'' +
                '}';
    }
}
