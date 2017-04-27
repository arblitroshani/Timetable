package com.arbli.timetable.model;

import java.io.Serializable;

public class CourseEvent implements Comparable<CourseEvent>, Serializable {

    private static int id_cnt = 0;
    private int id;

    private Course course;  // or: int courseId
    private String classroom;
    private int startingHour;
    private int duration;
    private int dayOfWeek; // 0 indexed: 0-5
    private int color;

    public CourseEvent(Course course, String classroom, int startingHour, int duration, int dayOfWeek, int color) {
        this.id = id_cnt++;
        this.course = course;
        this.classroom = classroom;
        this.startingHour = startingHour;
        this.duration = duration;
        this.dayOfWeek = dayOfWeek;
        this.color = color;
    }

    public CourseEvent(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int compareTo(CourseEvent courseEvent) {
        return startingHour - courseEvent.getStartingHour();
    }
}
