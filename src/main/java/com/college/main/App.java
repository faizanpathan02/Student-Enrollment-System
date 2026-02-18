package com.college.main;

import com.college.config.HibernateConfig;
import com.college.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.security.spec.ECField;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        Session session = HibernateConfig.getSessionFactory().openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            Department department = new Department();
            department.setName("Computer Science");

            Teacher teacher = new Teacher();
            teacher.setTeacher_name("Dr. Sharma");
            teacher.setEmail("sharma@college.com");
            teacher.setDepartment(department);

            Course course1 = new Course();
            course1.setTitle("Java Programming");
            course1.setCredits(4);
            course1.setTeacher(teacher);
            course1.setDepartment(department);

            Course course2 = new Course();
            course2.setTitle("Database Systems");
            course2.setCredits(5);
            course2.setTeacher(teacher);
            course2.setDepartment(department);

            department.setTeachers(Arrays.asList(teacher));
            department.setCourses(Arrays.asList(course1 , course2));

            teacher.setCourses(Arrays.asList(course1, course2));

            session.persist(department);
            transaction.commit();

            System.out.println("Department , Course and Teacher are set Successfully");

        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
