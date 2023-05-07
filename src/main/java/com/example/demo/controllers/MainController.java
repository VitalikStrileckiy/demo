package com.example.demo.controllers;

import com.example.demo.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model) {
        return "Main";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }
    @GetMapping("/dentist")
    public String dentist(Model model){
        return "dentist";
    }
}
