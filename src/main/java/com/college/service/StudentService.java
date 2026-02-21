package com.college.service;

import com.college.entity.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);
    Student getStudentById(int id);
    Student getStudentByEmail(String email);
    List<Student> getAllStudents();
    void update(Student student);
    void delete(int id);
}
