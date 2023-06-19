package com.example.roomdatabase;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insert(Course model);

    @Update
    void update(Course model);

    @Delete
    void delete(Course model);

    @Query("DELETE FROM course_table")
    void deleteAllCourses();

    @Query("SELECT * FROM course_table ORDER BY id DESC")
    List<Course> getAllCourses();
}
