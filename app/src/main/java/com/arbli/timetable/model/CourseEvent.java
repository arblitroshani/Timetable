package com.arbli.timetable.model;

import java.io.Serializable;

public class CourseEvent implements Comparable<CourseEvent>, Serializable {

    private int id;
    private int courseId;
    private String classroom;
    private int startingHour;
    private int duration;
    private int dayOfWeek;
    private int color;

    private Course course;

    public CourseEvent(){}

    public CourseEvent(int id, int courseId, String classroom, int startingHour, int duration, int dayOfWeek, int color) {
        this.id = id;
        this.courseId = courseId;
        this.classroom = classroom;
        this.startingHour = startingHour;
        this.duration = duration;
        this.dayOfWeek = dayOfWeek;
        this.color = color;
    }

    public CourseEvent(int duration) {
        this.duration = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int compareTo(CourseEvent courseEvent) {
        return startingHour - courseEvent.getStartingHour();
    }

    @Override
    public String toString() {
        return "Event: id:"+id+
                " class:" + classroom;
    }
}