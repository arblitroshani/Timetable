package com.arbli.timetable.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arbli.timetable.R;
import com.arbli.timetable.constant.Const;
import com.arbli.timetable.model.Course;
import com.arbli.timetable.model.CourseEvent;
import com.arbli.timetable.model.Professor;
import com.arbli.timetable.model.Student;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static com.arbli.timetable.data.DataPopulate.mCourses;
import static com.arbli.timetable.data.DataPopulate.mProfessors;

public class LoginActivity extends AppCompatActivity {


    private Button loginButton;
    private EditText usernameText,passwordText;

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeListener();
        populateData();
        initializeView();

    }

    //TODO : Query the userid(sent as extra from here) on the DayViewActivity and get all the lessons of the student department.

    private void initializeView(){

        loginButton= (Button) findViewById(R.id.login_button);
        usernameText=(EditText) findViewById(R.id.username_text);
        passwordText=(EditText) findViewById(R.id.password_text);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usernameText.getText().toString().length()==0 || passwordText.getText().toString().length()==0)
                    Toast.makeText(getApplicationContext(),"Fill out forms",Toast.LENGTH_LONG).show();
                else{
                    auth.signInWithEmailAndPassword(usernameText.getText().toString(),passwordText.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                            Intent i = new Intent(getApplicationContext(),DayViewActivity.class);
                            i.putExtra("USER_ID",authResult.getUser().getUid());
                            startActivity(i);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Not correct",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }

    private void populateData(){

        auth.createUserWithEmailAndPassword("ddaja15@epoka.edu.al","111223").addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                reference.child("Student").push().setValue(new Student(authResult.getUser().getUid(),"Deni",2017, Const.DEPARTMENT_CEN_ID,Const.FACULTY_FAE_ID));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        auth.createUserWithEmailAndPassword("atroshani15@epoka.edu.al","111223").addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                reference.child("Student").push().setValue(new Student(authResult.getUser().getUid(),"Arbli Troshani",2017,Const.DEPARTMENT_CEN_ID,Const.FACULTY_FAE_ID));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

//        reference.child("Course").push().setValue(new Course(0,"Introduction to Database", mProfessors.get(0).getId(), Const.FACULTY_FAE_ID, Const.DEPARTMENT_CEN_ID, 2, 2017,2015,4,10));
//        reference.child("Course").push().setValue(new Course(1,"Numerical Analysis", mProfessors.get(1).getId(), Const.FACULTY_FAE_ID, Const.DEPARTMENT_CEN_ID, 2, 2017));
//        reference.child("Course").push().setValue(new Course(2,"Digital Design", mProfessors.get(2).getId(), Const.FACULTY_FAE_ID, Const.DEPARTMENT_CEN_ID, 2, 2017));

//        reference.child("CourseEvent").push().setValue(new CourseEvent(0,mCourses.get(0).getId(), "E110", 1, 3, Const.WEEK_MON, 0));
//        reference.child("CourseEvent").push().setValue(new CourseEvent(1,mCourses.get(1).getId(), "A131", 5, 2, Const.WEEK_MON, 1));
//        reference.child("CourseEvent").push().setValue(new CourseEvent(2,mCourses.get(2).getId(), "A130", 7, 2, Const.WEEK_MON, 2));
//        reference.child("CourseEvent").push().setValue(new CourseEvent(3,mCourses.get(2).getId(), "A130", 10, 3, Const.WEEK_MON, 3));
//        reference.child("CourseEvent").push().setValue(new CourseEvent(4,mCourses.get(2).getId(), "A130", 4, 3, Const.WEEK_THU, 3));

//        reference.child("Professor").push().setValue(new Professor(0,"Elton Domnori", "edomnori", Const.TITLE_DR, "E210",Const.FACULTY_FAE_ID,new ArrayList<Integer>(0)));
//        reference.child("Professor").push().setValue(new Professor(1,"Arban Uka", "auka", Const.TITLE_DR, "E211",Const.FACULTY_FAE_ID,new ArrayList<Integer>(1)));
//        reference.child("Professor").push().setValue(new Professor(2,"Betim Cico", "bcico", Const.TITLE_PROF_DR, "E010",Const.FACULTY_FAE_ID,new ArrayList<Integer>(2)));
    }


    private void initializeListener(){

        firebaseDatabase=FirebaseDatabase.getInstance();
        reference=firebaseDatabase.getReferenceFromUrl("https://timetableproject-75b9c.firebaseio.com/");

        auth=FirebaseAuth.getInstance();

        authListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                } else {
                    // User is signed out
                }
            }
        };
    }


    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }


    @Override
    public void onStop(){
        super.onStop();
        if(authListener!=null){
            auth.removeAuthStateListener(authListener);
        }
    }

}