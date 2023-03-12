package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("");
        return "Main";
    }
    @GetMapping("Login")
    public String login(Model model){
        return "../html/Login";
    }



}