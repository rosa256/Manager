package com.personal.student.manager.demo.Repository;

import com.personal.student.manager.demo.Models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStudentRepository extends CrudRepository<Student, Long> {
    public List<Student> findTopByIdBefore(int count);
}
