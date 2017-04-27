package com.arbli.timetable.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Professor implements Serializable {

    private static int id_cnt=0;

    private int id;
    private String name;
    private String shortName;
    private String title;
    private String office;

    private ArrayList<Integer> courseIdList;

    public Professor(String name, String shortName, String title, String office, ArrayList<Integer> courseIdList) {
        this(name, shortName, title, office);
        this.courseIdList = courseIdList;

    }

    public Professor(String name, String shortName, String title, String office) {
        this.id = id_cnt++;;
        this.name = name;
        this.shortName = shortName;
        this.title = title;
        this.office = office;
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

    public ArrayList<Integer> getCourseIdList() {
        return courseIdList;
    }

    public void setCourseIdList(ArrayList<Integer> courseIdList) {
        this.courseIdList = courseIdList;
    }
}
