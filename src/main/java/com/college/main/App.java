package com.college.main;

import com.college.config.HibernateConfig;
import com.college.dao.CourseDAO;
import com.college.dao.impl.CourseDAOImpl;
import com.college.entity.*;

import java.util.List;

public class App {

    public static void main(String[] args) {

//        StudentDAO studentDAO = new StudentDAOImpl();
//
//        Student student = studentDAO.findByEmail("fk874451@gmail.com");
//
//        if (student != null){
//            System.out.println("Student Found ");
//            System.out.println(student);
//        }else {
//            System.out.println("Student Not Found");
//        }

        CourseDAO courseDAO = new CourseDAOImpl();
        Course course = new Course();
        course.setTitle("Hibernate Mastery");
        course.setCredits(4);
        courseDAO.save(course);
        System.out.println("Course saved successfully");

        Course fetched = courseDAO.findById(course.getId());
        System.out.println("Fetche Course :" + fetched);

        List<Course> courses = courseDAO.findAll();
        System.out.println("All Courses :");
        courses.forEach(System.out::println);

        HibernateConfig.shutdown();








    }
}
