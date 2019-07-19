package com.personal.student.manager.demo.Controllers;

import com.personal.student.manager.demo.Models.LoginForm;
import com.personal.student.manager.demo.Models.Student;
import com.personal.student.manager.demo.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class BasicController {

    private IStudentRepository studentRepository;

    public BasicController(IStudentRepository studentRepository){

        this.studentRepository = studentRepository;
    }


    @RequestMapping(value = {"/","/index","/login"}, method = RequestMethod.GET)
        public String showLoginHome(Model model, HttpSession session){
        Student student = (Student) session.getAttribute("activeStudent");
        model.addAttribute("loginForm", new LoginForm());

        if (student != null) {
            System.out.println(student.getName());
            return "student";
        }else {
            return "forms/loginForm";
        }
    }

    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String showRegisterForm(@ModelAttribute("student") Student student){
        return "forms/registerForm";
    }

    @RequestMapping(value = "/registerForm", method = RequestMethod.POST)
    public String processRegisterForm(@ModelAttribute("student") Student student){

        studentRepository.save(student);
        return "redirect:student/"+student.getId();
    }

    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String showLoginForm(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "forms/loginForm";
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public ModelAndView checkLoginForm(LoginForm loginForm, HttpSession session){

        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
        Integer result = studentRepository.countStudentByEmailInAndPasswordIn(email,password);
        ModelMap map = new ModelMap();
        map.addAttribute("student",studentRepository.findStudentByEmail(email));
        if(result > 0){
            session.setAttribute("activeStudent",studentRepository.findStudentByEmail(email));
            return new ModelAndView("student",map);
        }else{
            return new ModelAndView("forms/loginForm",map);
        }
    }

    @RequestMapping(method=RequestMethod.GET, value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}

