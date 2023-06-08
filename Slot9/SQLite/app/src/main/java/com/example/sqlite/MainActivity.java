package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText courseNameEdt, courseDurationEdt, courseTracksEdt, courseDescriptionEdt;
    private Button addCourseBtn, readCoursesBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseTracksEdt = findViewById(R.id.idEdtCourseTracks);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        addCourseBtn = findViewById(R.id.idBtnAddCourse);
        readCoursesBtn = findViewById(R.id.idBtnReadCourses);

        dbHandler = new DBHandler(MainActivity.this);

        addCourseBtn.setOnClickListener(v -> {
            String courseName = courseNameEdt.getText().toString();
            String courseDuration = courseDurationEdt.getText().toString();
            String courseTracks = courseTracksEdt.getText().toString();
            String courseDescription = courseDescriptionEdt.getText().toString();

            if (courseName.isEmpty() && courseDuration.isEmpty() && courseTracks.isEmpty() && courseDuration.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                return;
            }
            dbHandler.addNewCourse(courseName, courseDuration, courseDescription, courseTracks);
            Toast.makeText(MainActivity.this, "Course has been added", Toast.LENGTH_SHORT).show();
            courseNameEdt.setText("");
            courseDurationEdt.setText("");
            courseTracksEdt.setText("");
            courseDescriptionEdt.setText("");
        });

        readCoursesBtn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ViewCourses.class);
            startActivity(i);
        });

    }
}