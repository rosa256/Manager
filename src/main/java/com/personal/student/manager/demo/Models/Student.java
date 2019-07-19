package com.personal.student.manager.demo.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
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
        this.email = email;
    }

    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }
}


