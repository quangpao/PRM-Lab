package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private EditText edtCourseName, edtCourseDescription,
            edtCourseDuration;
    private Button btnAddCourse, btnReadCourses;
    CourseRepository res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initializing all our variables
        edtCourseName = findViewById(R.id.edtName);
        edtCourseDescription =
                findViewById(R.id.edtDescription);
        edtCourseDuration = findViewById(R.id.edtDuration);
        btnAddCourse = findViewById(R.id.btnAddCourse);
        btnReadCourses = findViewById(R.id.btnReadCourses);
        res = new CourseRepository(getApplication());
        btnAddCourse.setOnClickListener(v -> addCourse());
        btnReadCourses.setOnClickListener(v -> {
            //Opening ViewCourses activity via a intent
            Intent i = new Intent(MainActivity.this,
                ViewActivity.class);
            startActivity(i);
        });
    }
    public void addCourse()
    {
        Course course = new Course(edtCourseName.getText().toString(),edtCourseDescription.getText().toString(),edtCourseDuration.getText().toString());
        res.insert(course);
        Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
        edtCourseName.setText("");
        edtCourseDescription.setText("");
        edtCourseDuration.setText("");
    }
}