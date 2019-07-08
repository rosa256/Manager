package com.personal.student.manager.demo.Controllers;

import com.personal.student.manager.demo.Models.Student;
import com.personal.student.manager.demo.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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


    @RequestMapping(method = RequestMethod.GET)
    public String students(Model model){
        model.addAttribute("studentsList", studentRepository.findTopByIdBefore(1));
        return "students";
    }

    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String showRegisterForm(){
        return "registerForm";
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String processRegisterForm(Student student){
        studentRepository.save(student);
        return "redirect:/student";
    }
}
