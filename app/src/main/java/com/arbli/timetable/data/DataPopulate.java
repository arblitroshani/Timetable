package com.arbli.timetable.data;

import com.arbli.timetable.model.CourseEvent;
import com.arbli.timetable.model.Department;
import com.arbli.timetable.model.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class DataPopulate {

    private static DataPopulate instance = null;

    private ArrayList<CourseEvent> mEvents;
    private ArrayList<CourseEvent>[] week;
    private ArrayList<Integer> courseEventListID;

    private Student currentStudent;
    private Department currentDepartment;
    private int currentStudentDepartmentID;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference studentReference;
    private DatabaseReference departmentReference;
    private DatabaseReference courseEventReference;
    private DatabaseReference courseEventList1Reference;

    public static DataPopulate getInstance() {
        if (instance == null) {
            instance = new DataPopulate();
        }
        return instance;
    }

    protected DataPopulate() {
        mEvents = new ArrayList<>();
        courseEventListID = new ArrayList<>();
        week = (ArrayList<CourseEvent>[]) new ArrayList[6];

        firebaseDatabase = FirebaseDatabase.getInstance();
        studentReference = firebaseDatabase.getReference().child("Student");
        departmentReference = firebaseDatabase.getReference().child("Department");
        courseEventReference = firebaseDatabase.getReference().child("CourseEvent");
        courseEventList1Reference = firebaseDatabase.getReference().child("CourseEventList1");

        getStudent();
        prepareWeekList();
    }

    private void getStudent() {
        studentReference.orderByChild("name").equalTo("Deni").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                currentStudent = dataSnapshot.getValue(Student.class);

                currentStudentDepartmentID = currentStudent.getDepartmentId();

                departmentReference.orderByChild("id").equalTo(currentStudentDepartmentID).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        currentDepartment = dataSnapshot.getValue(Department.class);

                        courseEventList1Reference.child(currentDepartment.getId()+"").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                courseEventListID = dataSnapshot.getValue(new GenericTypeIndicator<ArrayList<Integer>>(){});
                            }
                            @Override public void onCancelled(DatabaseError databaseError) {}
                        });

                        for (int i = 0; i < courseEventListID.size(); i++){
                            courseEventReference.orderByChild("id").equalTo(courseEventListID.get(i)).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    mEvents.add(dataSnapshot.getValue(CourseEvent.class));
                                }
                                @Override public void onCancelled(DatabaseError databaseError) {}
                            });
                        }
                    }
                    @Override public void onCancelled(DatabaseError databaseError) {}
                });
            }
            @Override public void onCancelled(DatabaseError databaseError) {}
        });
    }

    private void prepareWeekList() {
        for (int i = 0; i < 6; i++)
            week[i] = new ArrayList<CourseEvent>();

        int mEventsSize = mEvents.size();
        for (int i = 0; i < mEventsSize; i++)
            week[mEvents.get(i).getDayOfWeek()].add(mEvents.get(i));
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
