package com.arbli.timetable.model;

import java.util.ArrayList;

public class Faculty {

    private int id;
    private String name;
    private ArrayList<Integer> departmentIds;

    public Faculty(){}

    public Faculty(int id, String name, ArrayList<Integer> departmentIds) {
        this.id = id;
        this.name = name;
        this.departmentIds = departmentIds;
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

    public ArrayList<Integer> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(ArrayList<Integer> departmentIds) {
        this.departmentIds = departmentIds;
    }
}
