package com.personal.student.manager.demo.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String password;
    private String email;
    private Integer age;
    public Student() {
    }

    public Student(String name, String surname, Integer age, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.age = age;
        this.email= email;
    }

    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}

