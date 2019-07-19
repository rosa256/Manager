package com.personal.student.manager.demo.Controllers;

import com.personal.student.manager.demo.Models.LoginForm;
import com.personal.student.manager.demo.Models.Student;
import com.personal.student.manager.demo.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginContext;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
@RequestMapping("/students")
public class StudentController {

    private final IStudentRepository studentRepository;

    @Autowired
    public StudentController(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addStudent(@RequestBody Student student){
        studentRepository.save(student);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String getStudent(@PathVariable Long id, HttpSession session){
        Student tempStudent = studentRepository.findById(id).get();
        if (session.getAttribute("activeStudent") == null) {
            session.setAttribute("activeStudent",tempStudent);
        }
        return "student";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getStudents(Model model){
        model.addAttribute("studentsList", studentRepository.findTopByIdBefore(1));
        return "students";
    }

}
