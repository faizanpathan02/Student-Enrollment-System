package com.college.service.impl;

import com.college.dao.StudentDAO;
import com.college.dao.impl.StudentDAOImpl;
import com.college.entity.Student;
import com.college.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO = new StudentDAOImpl();
    @Override
    public void addStudent(Student student) {
        Student existing = studentDAO.findByEmail(student.getEmail());
        if (existing != null) {
            throw new RuntimeException("Student with this email already exists");
        }

        studentDAO.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        Student student = studentDAO.findById(id);
        if (student == null) {
            throw new RuntimeException("Student not found for id : " + id);
        }
        return student;
    }

    @Override
    public Student getStudentByEmail(String email) {
        Student student = studentDAO.findByEmail(email);
        if (student == null) {
            throw new RuntimeException("Student not found with email : " + email);
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @Override
    public void update(Student student) {
        Student existing = studentDAO.findById(student.getId());
        if (student == null) {
            throw new RuntimeException("Cannot Update. Student Not Found");
        }
        studentDAO.update(student);

    }

    @Override
    public void delete(int id) {
        Student student = studentDAO.findById(id);
        if (student == null) {
            throw new RuntimeException("Cannot Delete. Student Not Found");
        }
        studentDAO.delete(student);

    }
}
