package com.college.dao;

import com.college.entity.Department;

import java.util.List;

public interface DepartmentDAO {

    void save(Department department);
    Department findById(int id);
    List<Department> findAll();
    void update(Department department);
    void delete(Department department);
}
