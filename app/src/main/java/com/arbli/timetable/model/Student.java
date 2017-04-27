package com.arbli.timetable.model;

import java.io.Serializable;

public class Student implements Serializable{

    private int id;
    private String name;
    private int studYear;
    private int departmentId;
    private int facultyId;
    private String email;

    public Student(){}

    public Student(int id, String name, int studYear, int departmentId, int facultyId, String email) {
        this.id = id;
        this.name = name;
        this.studYear = studYear;
        this.departmentId = departmentId;
        this.facultyId = facultyId;
        this.email = email;
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

    public int getStudYear() {
        return studYear;
    }

    public void setStudYear(int studYear) {
        this.studYear = studYear;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
