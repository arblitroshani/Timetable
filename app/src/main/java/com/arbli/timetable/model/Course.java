package com.arbli.timetable.model;

import java.io.Serializable;

public class Course implements Serializable{

    private static int id_cnt = 0;
    private int id;

    private int faculty;
    private int department;
    private int openYear;
    private int academicYear;

    private String courseName;
    private Professor professor;    // private int professorId;

    public Course(String courseName, Professor professor, int faculty, int department, int academicYear, int openYear) {
        id = id_cnt++;
        this.courseName = courseName;
        this.professor = professor;
        this.faculty = faculty;
        this.department = department;
        this.academicYear = academicYear;
        this.openYear = openYear;
    }

    public int getId() {
        return id;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public int getFaculty() {
        return faculty;
    }

    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getOpenYear() {
        return openYear;
    }

    public void setOpenYear(int openYear) {
        this.openYear = openYear;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(String professorName) {
        this.professor = professor;
    }
}
