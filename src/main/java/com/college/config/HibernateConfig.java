package com.college.config;

import com.college.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;
import java.util.Map;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    static {
        try {

            Map<String , Object> map = new HashMap<>();
            map.put("hibernate.connection.driver_class" , "com.mysql.cj.jdbc.Driver");
            map.put("hibernate.connection.url" , "jdbc:mysql://localhost:3306/college_db");
            map.put("hibernate.connection.username" , "root");
            map.put("hibernate.connection.password" , "Pathan@2001");
            map.put("hibernate.dialect" , "org.hibernate.dialect.MySQLDialect");
            map.put("hibernate.hbm2ddl.auto" , "update");
//            map.put("hibernate.show_sql" , "true");
//            map.put("hibernate.format_sql" , "true");

            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(map).build();

            MetadataSources sources = new MetadataSources(registry);
            sources.addAnnotatedClass(Student.class);
            sources.addAnnotatedClass(Address.class);
            sources.addAnnotatedClass(Course.class);
            sources.addAnnotatedClass(Teacher.class);
            sources.addAnnotatedClass(Department.class);

            Metadata metadata = sources.getMetadataBuilder().build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();

        }catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("SessionFactory creation failed");
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
