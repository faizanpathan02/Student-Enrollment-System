package com.college.service.impl;

import com.college.dao.CourseDAO;
import com.college.dao.impl.CourseDAOImpl;
import com.college.entity.Course;
import com.college.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private final CourseDAO courseDAO = new CourseDAOImpl();
    @Override
    public void save(Course course) {
        Course existing = courseDAO.findById(course.getId());
        if (existing != null) {
            throw new RuntimeException("Course with this id already exists");
        }
        courseDAO.save(course);
    }

    @Override
    public Course findById(int id) {
        return courseDAO.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public void update(Course course) {

        courseDAO.update(course);
    }

    @Override
    public void delete(Course course) {
        Course existing = courseDAO.findById(course.getId());
        if (existing != null) {
            courseDAO.delete(course);
        }else {
            System.out.println("Course not found with id : " + course.getId());
        }
    }
}
