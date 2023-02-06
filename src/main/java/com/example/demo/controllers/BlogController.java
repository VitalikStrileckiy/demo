package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class BlogController {

    public String blogMain(Model model){
        return "blog-main";
    }
}
