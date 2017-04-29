package com.arbli.timetable.data;

import com.arbli.timetable.model.Course;
import com.arbli.timetable.model.CourseEvent;
import com.arbli.timetable.model.Department;
import com.arbli.timetable.model.Professor;
import com.arbli.timetable.model.Student;
import com.google.firebase.auth.FirebaseAuth;
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

    private ArrayList<CourseEvent>[] week;

    private Student currentStudent = null;
    private Department currentDepartment = null;
    private ArrayList<Integer> courseEventListID;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference studentReference;
    private DatabaseReference departmentReference;
    private DatabaseReference courseReference;
    private DatabaseReference professorReference;
    private DatabaseReference courseEventReference;
    private DatabaseReference courseEventList1Reference;
    private String UID;

    private int i;
    private int courseEventListIDsize;
    private CourseEvent tmpCourseEvent;
    private Course tmpCourse;

    public static DataPopulate getInstance() {
        if (instance == null) {
            instance = new DataPopulate();
        }
        return instance;
    }

    protected DataPopulate() {
        i = 0;
        courseEventListID = new ArrayList<>();
        week = (ArrayList<CourseEvent>[]) new ArrayList[6];

        UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        studentReference = firebaseDatabase.getReference().child("Student");
        departmentReference = firebaseDatabase.getReference().child("Department");
        courseReference = firebaseDatabase.getReference().child("Course");
        professorReference = firebaseDatabase.getReference().child("Professor");
        courseEventReference = firebaseDatabase.getReference().child("CourseEvent");
        courseEventList1Reference = firebaseDatabase.getReference().child("CourseEventList1");

        for (int i = 0; i < 6; i++)
            week[i] = new ArrayList<>();

        getStudent();
    }

    private void addCourseEvent() {
        if (i == courseEventListIDsize) return;
        courseEventReference.orderByChild("id").equalTo(courseEventListID.get(i)).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tmpCourseEvent = dataSnapshot.getChildren().iterator().next().getValue(CourseEvent.class);
                courseReference.orderByChild("id").equalTo(tmpCourseEvent.getCourseId()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        tmpCourse = dataSnapshot.getChildren().iterator().next().getValue(Course.class);
                        professorReference.orderByChild("id").equalTo(tmpCourse.getProfessorId()).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                tmpCourse.setProfessor(dataSnapshot.getChildren().iterator().next().getValue(Professor.class));
                                tmpCourseEvent.setCourse(tmpCourse);
                                week[tmpCourseEvent.getDayOfWeek()].add(tmpCourseEvent);
                                i++;
                                addCourseEvent();
                            }
                            @Override public void onCancelled(DatabaseError databaseError) {}
                        });
                    }
                    @Override public void onCancelled(DatabaseError databaseError) {}
                });
            }
            @Override public void onCancelled(DatabaseError databaseError) {}
        });
    }

    private void getStudent() {
        studentReference.orderByChild("id").equalTo(UID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                currentStudent = dataSnapshot.getChildren().iterator().next().getValue(Student.class);
                departmentReference.orderByChild("id").equalTo(currentStudent.getDepartmentId()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        currentDepartment = dataSnapshot.getChildren().iterator().next().getValue(Department.class);
                        courseEventList1Reference.child(currentDepartment.getId() + "").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                courseEventListID = dataSnapshot.getValue(new GenericTypeIndicator<ArrayList<Integer>>(){});
                                courseEventListIDsize = courseEventListID.size();
                                addCourseEvent();
                            }
                            @Override public void onCancelled(DatabaseError databaseError) {}
                        });
                    }
                    @Override public void onCancelled(DatabaseError databaseError) {}
                });
            }
            @Override public void onCancelled(DatabaseError databaseError) {}
        });
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
