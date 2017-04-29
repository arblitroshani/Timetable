package com.arbli.timetable.model;

public class Department {

    private int id;
    private String name;
    private int headProfessorId;

    public Department(){}

    public Department(int id, String name, int headProfessorId) {
        this.id = id;
        this.name = name;
        this.headProfessorId = headProfessorId;
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

    public int getHeadProfessorId() {
        return headProfessorId;
    }

    public void setHeadProfessorId(int headProfessorId) {
        this.headProfessorId = headProfessorId;
    }

    @Override
    public String toString() {
        return "Department id:" + id +
                " name:" + name +
                " headProfId:" + headProfessorId;
    }
}
