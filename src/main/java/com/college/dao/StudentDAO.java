package com.college.dao;

import com.college.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    Student findById(int id);
    Student findByEmail(String email);
    List<Student> findAll();
    void update(Student student);
    void delete(Student student);
}