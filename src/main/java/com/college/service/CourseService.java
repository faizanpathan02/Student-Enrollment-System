package com.college.service;

import com.college.entity.Course;

import java.util.List;

public interface CourseService {

    void save(Course course);
    Course findById(int id);
    List<Course> findAll();
    void update(Course course);
    void delete(Course course);

}
