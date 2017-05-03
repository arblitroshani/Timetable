package com.arbli.timetable.model;

import java.io.Serializable;

public class Course implements Serializable {

    private String courseName;
    private String courseShortName;
    private String department;
    private String professorId;
    private int openYear;
    private int academicYear;

    public Course(){}

    public Course(String courseName, String courseShortName, String department, String professorId, int openYear, int academicYear) {
        this.courseName = courseName;
        this.courseShortName = courseShortName;
        this.department = department;
        this.professorId = professorId;
        this.openYear = openYear;
        this.academicYear = academicYear;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseShortName() {
        return courseShortName;
    }

    public void setCourseShortName(String courseShortName) {
        this.courseShortName = courseShortName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
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
}
