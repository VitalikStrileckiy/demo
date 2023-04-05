package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("");
        return "Main";
    }

    @GetMapping("/SignUp")
    public String signUp(Model model){
        return "SignUp";
    }

    @GetMapping("/UserPage")
    public String userPage(Model model){
        return "UserPage";
    }

}
