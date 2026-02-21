package com.college.dao.impl;

import com.college.config.HibernateConfig;
import com.college.dao.StudentDAO;
import com.college.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public void save(Student student) {
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()){

            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Student findById(int id) {
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            return session.get(Student.class , id);
        }
    }

    @Override
    public Student findByEmail(String email) {
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            return session.createNamedQuery("Student.findByEmail" , Student.class).setParameter("email" , email).uniqueResult();
        }

    }

    @Override
    public List<Student> findAll() {
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()){

            transaction = session.beginTransaction();
            return session.createQuery("FROM Student" , Student.class).getResultList();
        }
    }

    @Override
    public void update(Student student) {
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(student);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Student student) {
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.remove(student);
            transaction.commit();

        }

    }
}
