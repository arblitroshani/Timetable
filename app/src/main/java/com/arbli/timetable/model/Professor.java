package com.arbli.timetable.model;

import java.io.Serializable;

public class Professor implements Serializable {

    private String name;
    private String shortName;
    private String title;
    private String office;
    private String department;

    public Professor(){}

    public Professor(String name, String shortName, String title, String office, String department) {
        this.name = name;
        this.shortName = shortName;
        this.title = title;
        this.office = office;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
