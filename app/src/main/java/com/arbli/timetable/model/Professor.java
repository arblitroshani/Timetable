package com.arbli.timetable.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Professor implements Serializable {

    private int id;
    private String name;
    private String shortName;
    private String title;
    private String office;
    private int facultyId;
    private ArrayList<Integer> courseIdList;

    public Professor(){}

    public Professor(int id, String name, String shortName, String title, String office, int facultyId, ArrayList<Integer> courseIdList) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.title = title;
        this.office = office;
        this.facultyId = facultyId;
        this.courseIdList = courseIdList;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public ArrayList<Integer> getCourseIdList() {
        return courseIdList;
    }

    public void setCourseIdList(ArrayList<Integer> courseIdList) {
        this.courseIdList = courseIdList;
    }
}
