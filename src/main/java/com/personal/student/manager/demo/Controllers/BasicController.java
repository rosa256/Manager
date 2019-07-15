package com.personal.student.manager.demo.Controllers;

import com.personal.student.manager.demo.Models.Student;
import com.personal.student.manager.demo.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController {

    private IStudentRepository studentRepository;

    BasicController(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    @RequestMapping(value = {"/","/index","/login"}, method = RequestMethod.GET)
        public String showLoginHome(Model model){
        return "forms/loginForm";
        }

    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String showRegisterForm(Model model){
        model.addAttribute(new Student());
        return "forms/registerForm";
    }

    @RequestMapping(value = "/registerForm", method = RequestMethod.POST)
    public String procesRegisterForm(Student student){
        System.out.println(student.getName());
        studentRepository.save(student);
        return "redirect:/student/"+student.getId();
    }

}

