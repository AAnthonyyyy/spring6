package com.hgm.springiocxml.dimap;

public class Lesson {

    private String lessonName;

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public Lesson(String lessonName){
        this.lessonName=lessonName;
    }

    public Lesson(){

    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName='" + lessonName + '\'' +
                '}';
    }
}
