package com.spring_boot.simpleWebApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String greet(){
        return "Welcome to bineet!";
    }

    @RequestMapping("/about")
    public String about(){
        return "We don't teach, we Educate";
    }

}
