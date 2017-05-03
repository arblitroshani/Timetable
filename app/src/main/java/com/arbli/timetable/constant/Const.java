package com.arbli.timetable.constant;

import com.arbli.timetable.R;

public class Const {

    public static final String FAC_FAE = "FAE";
    public static final String FAC_FAE_NAME = "Faculty of Architechture and Engineering";
    public static final String FAC_FAE_HEAD = "Husein Bilgin";
    public static final String FAC_FEAS = "FEAS";

    public static final String DEP_CEN = "CEN";
    public static final String DEP_CEN_NAME = "Computer Engineering";
    public static final String DEP_CEN_HEAD = "Arban Uka";
    public static final String DEP_ECE = "ECE";
    public static final String DEP_ARCH = "ARCH";

    public static final int EVENT_EMPTY = 0;
    public static final int EVENT_LENGTH_1 = 1;
    public static final int EVENT_LENGTH_2 = 2;
    public static final int EVENT_LENGTH_3 = 3;

    public static final String[] DAYS_LONG = new String[]{
            "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};

    public static final String[] DAYS_SHORT = new String[]{
            "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static final int COLORS_NUM = 5;
    public static final int[] COLOR_ARRAY = {
            R.color.event_color_1,
            R.color.event_color_2,
            R.color.event_color_3,
            R.color.event_color_4,
            R.color.event_color_5
    };

    public static final int WEEK_MON = 0;
    public static final int WEEK_TUE = 1;
    public static final int WEEK_WED = 2;
    public static final int WEEK_THU = 3;
    public static final int WEEK_FRI = 4;
    public static final int WEEK_SAT = 5;

    public static final String COURSE_EVENT_OBJECT_TAG = "course_event_object";

    public static final int SCHOOL_START_MINUTES = 8*60 + 45;
    public static final int SCHOOL_END_MINUTES = 20*60 + 30;

    public static final String TITLE_MSC = "M.Sc.";
    public static final String TITLE_DR = "Dr.";
    public static final String TITLE_PROF = "Prof.";
    public static final String TITLE_PROF_DR = "Prof. Dr.";
    public static final String TITLE_NOT = "";

    public static final String REF_STUDENTS = "students";
    public static final String REF_PROFESSORS = "professors";
    public static final String REF_DEPARTMENTS = "departments";
    public static final String REF_FACULTIES = "faculties";
    public static final String REF_COURSES = "courses";
    public static final String REF_COURSEEVENTS = "course_events";
    public static final String REF_ADMIN = "admin";

}
