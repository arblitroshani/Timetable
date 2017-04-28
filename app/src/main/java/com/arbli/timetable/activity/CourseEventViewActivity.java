package com.arbli.timetable.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.arbli.timetable.R;
import com.arbli.timetable.constant.Const;
import com.arbli.timetable.model.CourseEvent;

public class CourseEventViewActivity extends AppCompatActivity {

    private TextView tvCourseName;
    private TextView tvProfName;
    private TextView tvClassroom;

    private CourseEvent mCourseEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_event_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvCourseName = (TextView) findViewById(R.id.tvCourseName);
        tvProfName = (TextView) findViewById(R.id.tvProfName);
        tvClassroom = (TextView) findViewById(R.id.tvClassroom);

        Intent intent = getIntent();
        if (intent.hasExtra(Const.COURSE_EVENT_OBJECT_TAG)) {
            mCourseEvent = (CourseEvent) intent.getSerializableExtra(Const.COURSE_EVENT_OBJECT_TAG);
        }

        //tvCourseName.setText(mCourseEvent.getCourse().getCourseName());
        //tvProfName.setText(mCourseEvent.getCourse().getProfessor().getName());
        //tvClassroom.setText(mCourseEvent.getClassroom());
    }

}
