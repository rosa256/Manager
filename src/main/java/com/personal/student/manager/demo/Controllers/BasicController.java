package com.personal.student.manager.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController {
    @RequestMapping(value = {"/","/index","/home"}, method = RequestMethod.GET)
        public String home(){
            return "index";
        }
}
