package com.arbli.timetable.model;

import java.util.ArrayList;

public class DepartmentCourses {

    private int departmentId;
    private ArrayList<Integer> courseEventIdsYear1;
    private ArrayList<Integer> courseEventIdsYear2;
    private ArrayList<Integer> courseEventIdsYear3;

    public DepartmentCourses(){}

    public DepartmentCourses(int departmentId, ArrayList<Integer> courseEventIdsYear1, ArrayList<Integer> courseEventIdsYear2, ArrayList<Integer> courseEventIdsYear3) {
        this.departmentId = departmentId;
        this.courseEventIdsYear1 = courseEventIdsYear1;
        this.courseEventIdsYear2 = courseEventIdsYear2;
        this.courseEventIdsYear3 = courseEventIdsYear3;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public ArrayList<Integer> getCourseEventIdsYear1() {
        return courseEventIdsYear1;
    }

    public void setCourseEventIdsYear1(ArrayList<Integer> courseEventIdsYear1) {
        this.courseEventIdsYear1 = courseEventIdsYear1;
    }

    public ArrayList<Integer> getCourseEventIdsYear2() {
        return courseEventIdsYear2;
    }

    public void setCourseEventIdsYear2(ArrayList<Integer> courseEventIdsYear2) {
        this.courseEventIdsYear2 = courseEventIdsYear2;
    }

    public ArrayList<Integer> getCourseEventIdsYear3() {
        return courseEventIdsYear3;
    }

    public void setCourseEventIdsYear3(ArrayList<Integer> courseEventIdsYear3) {
        this.courseEventIdsYear3 = courseEventIdsYear3;
    }
}
