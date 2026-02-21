package com.college.dao.impl;

import com.college.config.HibernateConfig;
import com.college.dao.DepartmentDAO;
import com.college.entity.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public void save(Department department) {
        Transaction transaction = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.persist(department);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Department findById(int id) {

        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Department.class , id);
        }
    }

    @Override
    public List<Department> findAll() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()){

            return session.createQuery("FROM Department " , Department.class).getResultList();
        }
    }

    @Override
    public void update(Department department) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){

            transaction = session.beginTransaction();
            session.merge(department);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Department department) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){

            transaction = session.beginTransaction();
            session.remove(department);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }

    }
}
