package com.arbli.timetable.model;

public class Student {

    private static int id_cnt = 0;

    private int id;
    private String name;
    private int enrollYear;
    private int studYear;
    private int department;
    private int faculty;

    public Student(String name, int enrollYear, int studYear, int department, int faculty) {
        this.id = id_cnt++;
        this.name = name;
        this.enrollYear = enrollYear;
        this.studYear = studYear;
        this.department = department;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnrollYear() {
        return enrollYear;
    }

    public void setEnrollYear(int enrollYear) {
        this.enrollYear = enrollYear;
    }

    public int getStudYear() {
        return studYear;
    }

    public void setStudYear(int studYear) {
        this.studYear = studYear;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getFaculty() {
        return faculty;
    }

    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }
}
