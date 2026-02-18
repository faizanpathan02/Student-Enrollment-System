package com.college.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")

@NamedQuery(
        name = "Student.findByEmail",
        query = "FROM Student s WHERE s.email = :email"
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @Column(name = "name" , nullable = false , length = 100)
    private String name;

    @Column(name = "email" , nullable = false , length = 50)
    private String email;

    @Column(name = "age")
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id" , referencedColumnName = "address_id")
    private Address address;

    public Student(){

    }

    public Student(int id, String name, String email, int age, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return   "Student" +
                "---------------------------"+
                "id        " + id + "\n" +
                "name      " + name + "\n" +
                "email     " + email + "\n" +
                "age       " + age + "\n" +
                "address   " + address ;
    }
}
