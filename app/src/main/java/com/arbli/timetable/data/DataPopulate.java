package com.arbli.timetable.data;

import android.app.Activity;
import android.util.Log;

import com.arbli.timetable.constant.Const;
import com.arbli.timetable.model.CourseEvent;
import com.arbli.timetable.model.Student;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class DataPopulate {

    private static DataPopulate instance = null;

    private ArrayList<CourseEvent>[] day;

    private Student mStudent;
    private String mDepartment;
    private int mYearStud;
    private FirebaseDatabase db;
    private DatabaseReference dbRefStudents;

    private int i;

    public static DataPopulate getInstance(Activity activity) {
        if (instance == null) {
            instance = new DataPopulate(activity);
        }
        return instance;
    }

    protected DataPopulate(Activity activity) {
        day = (ArrayList<CourseEvent>[]) new ArrayList[6];

        for (int i = 0; i < 6; i++)
            day[i] = new ArrayList<>();

        db = FirebaseDatabase.getInstance();
        dbRefStudents = db.getReference().child(Const.REF_STUDENTS);

        getStudent();

    }

    private void getStudent() {
        dbRefStudents.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mStudent = dataSnapshot.getValue(Student.class);
                mDepartment = mStudent.getDepartment();
                mYearStud = mStudent.getStudYear();
                Log.i("TAG", "Student name: " + mStudent.getName());
                Log.i("TAG", "DEP: "+mDepartment);
                getCourseEvents();
            }
            @Override public void onCancelled(DatabaseError databaseError) {}
        });
    }

    private void getCourseEvents() {
        DatabaseReference dbRefCourseEvents = db.getReference().child(Const.REF_COURSEEVENTS).child(mDepartment).child(mYearStud+"");
        dbRefCourseEvents.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("TAG", "number of dataSnap "+dataSnapshot.getChildrenCount());
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    CourseEvent ce = dsp.getValue(CourseEvent.class);
                    Log.i("TAG", ""+ce.getNameOfCourse());
                    day[ce.getDayOfWeek()].add(ce);
                }
            }
            @Override public void onCancelled(DatabaseError databaseError) {}
        });
    }

    public ArrayList<CourseEvent> getCoursesOfDay(int d) {
        return day[d];
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
