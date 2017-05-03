package com.arbli.timetable.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class CourseEvent implements Comparable<CourseEvent>, Serializable {

    private String nameOfCourse;
    private String professorShortName;
    private String courseId;
    private String professorId;
    private String classroom;
    private int startingHour;
    private int duration;
    private int dayOfWeek;
    private int color;

    public CourseEvent(){}

    public CourseEvent(String nameOfCourse, String professorShortName, String courseId, String professorId,
                       String classroom, int startingHour, int duration, int dayOfWeek, int color) {
        this.nameOfCourse = nameOfCourse;
        this.professorShortName = professorShortName;
        this.courseId = courseId;
        this.professorId = professorId;
        this.classroom = classroom;
        this.startingHour = startingHour;
        this.duration = duration;
        this.dayOfWeek = dayOfWeek;
        this.color = color;
    }

    public CourseEvent(int duration) {
        this.duration = duration;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public String getProfessorShortName() {
        return professorShortName;
    }

    public void setProfessorShortName(String professorShortName) {
        this.professorShortName = professorShortName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(int startingHour) {
        this.startingHour = startingHour;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int compareTo(@NonNull CourseEvent courseEvent) {
        return startingHour - courseEvent.getStartingHour();
    }
}