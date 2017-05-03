package com.arbli.timetable.model;

public class Department {

    private String name;
    private String headProfessorName;
    private String faculty;

    public Department(){}

    public Department(String name, String headProfessorName, String faculty) {
        this.name = name;
        this.headProfessorName = headProfessorName;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadProfessorName() {
        return headProfessorName;
    }

    public void setHeadProfessorName(String headProfessorName) {
        this.headProfessorName = headProfessorName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
