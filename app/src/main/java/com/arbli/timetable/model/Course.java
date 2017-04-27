package com.arbli.timetable.model;

import java.io.Serializable;

public class Course implements Serializable{

    private int id;
    private String courseName;
    private int facultyId;
    private int departmentId;
    private int openYear;
    private int academicYear;
    private int professorId;

    public Course(){}

    public Course(int id, String courseName, int professorId, int facultyId, int departmentId, int academicYear, int openYear) {
        this.id = id;
        this.courseName = courseName;
        this.professorId = professorId;
        this.facultyId = facultyId;
        this.departmentId = departmentId;
        this.academicYear = academicYear;
        this.openYear = openYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getOpenYear() {
        return openYear;
    }

    public void setOpenYear(int openYear) {
        this.openYear = openYear;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }
}
