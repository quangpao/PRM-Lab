package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateCourse extends AppCompatActivity {

    private EditText courseNameEdt, courseDurationEdt, courseTracksEdt, courseDescriptionEdt;
    private Button updateCourseBtn, deleteCourseBtn;
    private DBHandler dbHandler;
    String courseName, courseDuration, courseTracks, courseDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course);

        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseTracksEdt = findViewById(R.id.idEdtCourseTracks);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        updateCourseBtn = findViewById(R.id.idBtnUpdateCourse);
        deleteCourseBtn = findViewById(R.id.idBtnDeleteCourse);

        dbHandler = new DBHandler(UpdateCourse.this);

        courseName = getIntent().getStringExtra("name");
        courseDuration = getIntent().getStringExtra("duration");
        courseTracks = getIntent().getStringExtra("tracks");
        courseDescription = getIntent().getStringExtra("description");

        courseNameEdt.setText(courseName);
        courseDurationEdt.setText(courseDuration);
        courseTracksEdt.setText(courseTracks);
        courseDescriptionEdt.setText(courseDescription);

        updateCourseBtn.setOnClickListener(v -> {
            dbHandler.updateCourse(courseName,
                    courseNameEdt.getText().toString(),
                    courseDurationEdt.getText().toString(),
                    courseDescriptionEdt.getText().toString(),
                    courseTracksEdt.getText().toString());

            Toast.makeText(UpdateCourse.this, "Course Updated..", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(UpdateCourse.this, MainActivity.class);
            startActivity(i);
        });

        deleteCourseBtn.setOnClickListener(v -> {
            dbHandler.deleteCourse(courseName);
            Toast.makeText(UpdateCourse.this, "Course Deleted..", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(UpdateCourse.this, MainActivity.class);
            startActivity(i);
        });
    }
}