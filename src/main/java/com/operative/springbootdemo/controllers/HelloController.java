package com.operative.springbootdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String welcome(){
        System.out.println("Hello controller:welcome");
        return ("Welcome to SpringBoot");
    }

    @GetMapping("/home")
    public String home(){
        System.out.println("inside home controller");
        return "home controller";
    }
}
