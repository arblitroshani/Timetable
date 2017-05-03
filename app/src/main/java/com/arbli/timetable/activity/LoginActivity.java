package com.arbli.timetable.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arbli.timetable.R;
import com.arbli.timetable.constant.Const;
import com.arbli.timetable.model.Course;
import com.arbli.timetable.model.CourseEvent;
import com.arbli.timetable.model.Department;
import com.arbli.timetable.model.Faculty;
import com.arbli.timetable.model.Professor;
import com.arbli.timetable.model.Student;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    }

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
                    auth.signInWithEmailAndPassword(usernameText.getText().toString(), passwordText.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                                Intent i = new Intent(getApplicationContext(), DayViewActivity.class);
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

        auth.createUserWithEmailAndPassword("ddaja15@epoka.edu.al", "111223").addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Student newStudent = new Student("Deni Daja", authResult.getUser().getEmail(), 2, Const.DEP_CEN);
                reference.child(Const.REF_STUDENTS).child(authResult.getUser().getUid()).setValue(newStudent);
                reference.child(Const.REF_ADMIN).child(authResult.getUser().getUid()).setValue(true);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override public void onFailure(@NonNull Exception e) {}
        });

        auth.createUserWithEmailAndPassword("atroshani15@epoka.edu.al","111223").addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Student newStudent = new Student("Arbli Troshani", authResult.getUser().getEmail(), 2, Const.DEP_CEN);
                reference.child("students").child(authResult.getUser().getUid()).setValue(newStudent);
                reference.child(Const.REF_ADMIN).child(authResult.getUser().getUid()).setValue(true);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override public void onFailure(@NonNull Exception e) {}
        });

        reference.child(Const.REF_FACULTIES).child(Const.FAC_FAE).setValue(new Faculty(Const.FAC_FAE_NAME, Const.FAC_FAE_HEAD));
        reference.child(Const.REF_DEPARTMENTS).child(Const.DEP_CEN).setValue(new Department(Const.DEP_CEN_NAME, Const.DEP_CEN_HEAD, Const.FAC_FAE));

        Professor databaseProfessor = new Professor("Elton Domnori", "edomnori", Const.TITLE_DR, "1", Const.DEP_CEN);
        DatabaseReference dbRefProf = reference.child(Const.REF_PROFESSORS).push();
        dbRefProf.setValue(databaseProfessor);
        Course databaseCourse = new Course("Database Management Systems", "CEN 252", Const.DEP_CEN, dbRefProf.getKey(), 2016, 2);
        DatabaseReference dbRefCourse = reference.child(Const.REF_COURSES).push();
        dbRefCourse.setValue(databaseCourse);
        CourseEvent ce1 = new CourseEvent(databaseCourse.getCourseName(), databaseProfessor.getShortName(), dbRefCourse.getKey(), dbRefProf.getKey(), "E110-A", 6, 2, 0, 0);
        CourseEvent ce2 = new CourseEvent(databaseCourse.getCourseName(), databaseProfessor.getShortName(), dbRefCourse.getKey(), dbRefProf.getKey(), "PC-LAB1", 5, 2, 2, 0);
        CourseEvent ce3 = new CourseEvent(databaseCourse.getCourseName(), databaseProfessor.getShortName(), dbRefCourse.getKey(), dbRefProf.getKey(), "PC-LAB1", 1, 2, 4, 0);
        DatabaseReference ceRef = reference.child(Const.REF_COURSEEVENTS).child(databaseCourse.getDepartment()).child(databaseCourse.getAcademicYear()+"");
        ceRef.child(ceRef.push().getKey()).setValue(ce1);
        ceRef.child(ceRef.push().getKey()).setValue(ce2);
        ceRef.child(ceRef.push().getKey()).setValue(ce3);
    }

    private void initializeListener(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference();
        auth = FirebaseAuth.getInstance();

        authListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent i = new Intent(getApplicationContext(), DayViewActivity.class);
                    startActivity(i);
                } else {
                    initializeView();
                    //populateData();
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