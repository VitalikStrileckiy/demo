package com.example.demo.controllers;

import com.example.demo.dto.AppointmentDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/SignUp")
    public String signUp(Model model){

        return "SignUp";
    }



}