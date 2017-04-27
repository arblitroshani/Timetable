package com.arbli.gridweek1.data;

import com.arbli.gridweek1.constant.Const;
import com.arbli.gridweek1.model.Course;
import com.arbli.gridweek1.model.CourseEvent;

import java.util.ArrayList;
import java.util.Collections;

public class DataPopulate {

    private static DataPopulate instance = null;

    public static ArrayList<CourseEvent> mEvents;
    public static ArrayList<Course> mCourses;
    public static ArrayList<CourseEvent>[] week;

    //deni

    public static DataPopulate getInstance() {
        if (instance == null) {
            instance = new DataPopulate();
        }
        return instance;
    }

    protected DataPopulate() {
        mEvents = new ArrayList<>();
        mCourses = new ArrayList<>();
        week = (ArrayList<CourseEvent>[]) new ArrayList[6];

        addData();
        prepareWeekList();
    }

    private void addData() {
        mCourses.add(new Course("Introduction to Database", "edomnori", Const.FACULTY_FAE_ID, Const.DEPARTMENT_CEN_ID, 2, 2017));
        mCourses.add(new Course("Numerical Analysis", "auka", Const.FACULTY_FAE_ID, Const.DEPARTMENT_CEN_ID, 2, 2017));
        mCourses.add(new Course("Digital Design", "bcico", Const.FACULTY_FAE_ID, Const.DEPARTMENT_CEN_ID, 2, 2017));

        mEvents.add(new CourseEvent(mCourses.get(0), "E110", 1, 3, Const.WEEK_MON, 0));
        mEvents.add(new CourseEvent(mCourses.get(1), "A131", 5, 2, Const.WEEK_MON, 1));
        mEvents.add(new CourseEvent(mCourses.get(2), "A130", 7, 2, Const.WEEK_MON, 2));
        mEvents.add(new CourseEvent(mCourses.get(2), "A130", 10, 3, Const.WEEK_MON, 3));
        mEvents.add(new CourseEvent(mCourses.get(2), "A130", 10, 1, Const.WEEK_TUE, 4));
        mEvents.add(new CourseEvent(mCourses.get(2), "A130", 4, 3, Const.WEEK_THU, 3));
    }

    private void prepareWeekList() {
        for (int i = 0; i < 6; i++)
            week[i] = new ArrayList<CourseEvent>();

        int mEventsSize = mEvents.size();
        for (int i = 0; i < mEventsSize; i++)
            week[mEvents.get(i).getDayOfWeek()].add(mEvents.get(i));
    }

    public int courseEventsCnt() {
        return mEvents.size();
    }

    public ArrayList<CourseEvent> getCoursesOfDay(int day) {
        return week[day];
    }

    public ArrayList<CourseEvent> getListReadyEvents(ArrayList<CourseEvent> mEventsFiltered) {
        ArrayList<CourseEvent> courseEventsFinal = new ArrayList<>();
        int initialCount = mEventsFiltered.size();
        int index = 0;
        Collections.sort(mEventsFiltered);
        CourseEvent tmp;
        for (int i = 1; i <= 12; i++) {
            if (index == initialCount) break;
            tmp = mEventsFiltered.get(index);
            if (tmp.getStartingHour() == i) {
                courseEventsFinal.add(tmp);
                i = tmp.getStartingHour() + tmp.getDuration() - 1;
                index++;
            } else {
                for (; i < tmp.getStartingHour() && i <= 12; i++)
                    courseEventsFinal.add(new CourseEvent(0));
                i--;
            }
        }
        return courseEventsFinal;
    }

    public ArrayList<CourseEvent> getEvents(int day) {
        return getListReadyEvents(getCoursesOfDay(day));
    }
}
