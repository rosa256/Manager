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
    private Integer age;
    public Student() {
    }

    public Student(String name, String surname, Integer age, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.age = age;
    }

    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }

}

