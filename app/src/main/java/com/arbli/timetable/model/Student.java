package com.arbli.timetable.model;

import java.io.Serializable;

public class Student implements Serializable{

    private String id;
    private String name;
    private int studYear;
    private int departmentId;
    private int facultyId;
    private boolean adminPrivilege;

    public Student(){}

    public Student(String id, String name, int studYear, int departmentId, int facultyId) {
        this.id = id;
        this.name = name;
        this.studYear = studYear;
        this.departmentId = departmentId;
        this.facultyId = facultyId;
    }

    public Student(String id, String name, int studYear, int departmentId, int facultyId, boolean adminPrivilege) {
        this.id = id;
        this.name = name;
        this.studYear = studYear;
        this.departmentId = departmentId;
        this.facultyId = facultyId;
        this.adminPrivilege=adminPrivilege;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public boolean isAdminPrivilege() {
        return adminPrivilege;
    }

    public void setAdminPrivilege(boolean adminPrivilege) {
        this.adminPrivilege = adminPrivilege;
    }

    @Override
    public String toString() {
        return "id:" + id +
                " name:" + name +
                " studyear:" + studYear +
                " depid: " + departmentId +
                " fid:" + facultyId;
    }
}