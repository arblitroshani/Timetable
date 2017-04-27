package com.arbli.timetable.constant;

import com.arbli.timetable.R;

public class Const {

    public static final int FACULTY_FAE_ID = 0;
    public static final int FACULTY_FEAS_ID = 1;

    public static final int DEPARTMENT_CEN_ID = 0;
    public static final int DEPARTMENT_ECE_ID = 1;
    public static final int DEPARTMENT_ARCH_ID = 2;

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

    public static String TITLE_MSC = "M.Sc.";
    public static String TITLE_DR = "Dr.";
    public static String TITLE_PROF = "Prof.";
    public static String TITLE_PROF_DR = "Prof. Dr.";
    public static String TITLE_NOT = "";

}
