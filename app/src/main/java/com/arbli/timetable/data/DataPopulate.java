package com.arbli.timetable.data;

import com.arbli.timetable.model.CourseEvent;

import java.util.ArrayList;
import java.util.Collections;

public class DataPopulate {

    private static DataPopulate instance = null;

    public static ArrayList<CourseEvent> mEvents;
    public static ArrayList<CourseEvent>[] week;

    public static DataPopulate getInstance(ArrayList<CourseEvent> courseEvents) {
        if (instance == null) {
            instance = new DataPopulate(courseEvents);
        }
        return instance;
    }

    public static DataPopulate getInstance() {
        return getInstance(null);
    }

    protected DataPopulate(ArrayList<CourseEvent> courseEvents) {
        mEvents = courseEvents;
        week = (ArrayList<CourseEvent>[]) new ArrayList[6];

        prepareWeekList();
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

    private ArrayList<CourseEvent> getListReadyEvents(ArrayList<CourseEvent> mEventsFiltered) {
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
