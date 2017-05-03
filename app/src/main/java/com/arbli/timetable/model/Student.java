package com.arbli.timetable.model;

import java.io.Serializable;

public class Student implements Serializable{

    private String name;
    private String email;
    private int studYear;
    private String department;

    public Student(){}

    public Student(String name, String email, int studYear, String department) {
        this.name = name;
        this.email = email;
        this.studYear = studYear;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStudYear() {
        return studYear;
    }

    public void setStudYear(int studYear) {
        this.studYear = studYear;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}