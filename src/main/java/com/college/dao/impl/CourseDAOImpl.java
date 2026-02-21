package com.college.dao.impl;

import com.college.config.HibernateConfig;
import com.college.dao.CourseDAO;
import com.college.entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.dialect.H2DurationIntervalSecondJdbcType;

import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public void save(Course course) {
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();

        }catch (Exception e){
            if(transaction!=null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Course findById(int id) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {

            return session.get(Course.class , id);
        }

    }

    @Override
    public List<Course> findAll() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()){

            return session.createQuery("FROM Course " , Course.class).getResultList();
        }

    }

    @Override
    public void update(Course course) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){

            transaction = session.beginTransaction();
            session.merge(course);
            transaction.commit();

        }catch (Exception e){
            if (transaction!= null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Course course) {

        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.remove(course);
            transaction.commit();

        }catch (Exception e){
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }

    }
}
