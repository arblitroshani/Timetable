package com.arbli.timetable.model;

public class Faculty {

    private String name;
    private String headProfessorName;

    public Faculty(){}

    public Faculty(String name, String headProfessorName) {
        this.name = name;
        this.headProfessorName= headProfessorName;
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
}
