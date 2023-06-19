package com.example.roomdatabase;

import android.app.Application;

import java.util.List;

public class CourseRepository {

    public static Dao dao;

    public CourseRepository(Application application) {
        CourseDatabase database = CourseDatabase.getInstance(application);
        dao = database.dao();
    }

    public void insert(Course course) {
        dao.insert(course);
    }

    public void update(Course course) {
        dao.update(course);
    }

    public void delete(Course course) {
        dao.delete(course);
    }

    public void deleteAll() {
        dao.deleteAllCourses();
    }

    public List<Course> getAll() {
        return dao.getAllCourses();
    }
}
