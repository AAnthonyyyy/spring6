package com.hgm.springiocxml.dimap;

import java.util.List;
import java.util.Map;

public class Student {

    private List<Lesson> lessonList;

    private Map<String,Teacher> teacherMap;

    private String sid;
    private String sname;

    public Student(){

    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void info() {
        System.out.println("学生编号：" + sid + "学生的名称：" + sname);
        System.out.println(teacherMap);
        System.out.println(lessonList);
    }

    @Override
    public String toString() {
        return "Student{" +
                "lessonList=" + lessonList +
                ", teacherMap=" + teacherMap +
                ", sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }
}
