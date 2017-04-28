package com.arbli.timetable.model;

import java.util.ArrayList;

public class Department {

    private int id;
    private String name;
    private int headProfessorId;
    private ArrayList<Integer> courseList1;
    private ArrayList<Integer> courseList2;
    private ArrayList<Integer> courseList3;
    private ArrayList<Integer> courseEventList1;
    private ArrayList<Integer> courseEventList2;
    private ArrayList<Integer> courseEventList3;


    public Department(){}

    public Department(int id, String name, int headProfessorId) {
        this.id = id;
        this.name = name;
        this.headProfessorId = headProfessorId;
        courseEventList1= new ArrayList<>();
        courseEventList2= new ArrayList<>();
        courseEventList3= new ArrayList<>();
        courseList1 = new ArrayList<>();
        courseList2 = new ArrayList<>();
        courseList3 = new ArrayList<>();
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

    public ArrayList<Integer> getCourseList1() {
        return courseList1;
    }

    public void setCourseList1(ArrayList<Integer> courseList1) {
        this.courseList1 = courseList1;
    }

    public ArrayList<Integer> getCourseList2() {
        return courseList2;
    }

    public void setCourseList2(ArrayList<Integer> courseList2) {
        this.courseList2 = courseList2;
    }

    public ArrayList<Integer> getCourseList3() {
        return courseList3;
    }

    public void setCourseList3(ArrayList<Integer> courseList3) {
        this.courseList3 = courseList3;
    }

    public ArrayList<Integer> getCourseEventList1() {
        return courseEventList1;
    }

    public void setCourseEventList1(ArrayList<Integer> courseEventList1) {
        this.courseEventList1 = courseEventList1;
    }

    public ArrayList<Integer> getCourseEventList2() {
        return courseEventList2;
    }

    public void setCourseEventList2(ArrayList<Integer> courseEventList2) {
        this.courseEventList2 = courseEventList2;
    }

    public ArrayList<Integer> getCourseEventList3() {
        return courseEventList3;
    }

    public void setCourseEventList3(ArrayList<Integer> courseEventList3) {
        this.courseEventList3 = courseEventList3;
    }
}
