package com.arbli.timetable.model;

import java.util.ArrayList;

public class Department {

    private int id;
    private String name;
    private int headProfessorId;
    private ArrayList<Integer> courseList;

    public Department(){}

    public Department(int id, String name, int headProfessorId, ArrayList<Integer> courseList) {
        this.id = id;
        this.name = name;
        this.headProfessorId = headProfessorId;
        this.courseList = courseList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeadProfessorId() {
        return headProfessorId;
    }

    public void setHeadProfessorId(int headProfessorId) {
        this.headProfessorId = headProfessorId;
    }

    public ArrayList<Integer> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Integer> courseList) {
        this.courseList = courseList;
    }
}
