package com.personal.student.manager.demo.Repository;

import com.personal.student.manager.demo.Models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {
    List<Student> findTopByIdBefore(int count);
    Integer countStudentByEmailInAndPasswordIn(String email, String password);
    Student findStudentByEmail(String email);
}
