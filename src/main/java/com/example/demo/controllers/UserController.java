package com.example.demo.controllers;

import com.example.demo.entity.Journal;
import com.example.demo.entity.Patient;
import com.example.demo.repo.JournalRepository;
import com.example.demo.repo.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    JournalRepository journalRepo;
    @Autowired
    PatientRepository patientRepo;


    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @GetMapping("/UserPage")
    public String userPage(Principal principal, Model model) {

        Authentication authentication = (Authentication) principal;
        User user = (User) authentication.getPrincipal();
        final String username = user.getUsername();
        Patient patient = patientRepo.getPatientByUsername(username);
        final List<Journal> patientRecords = journalRepo.findPatientRecords(patient.getId());

        model.addAttribute("patientRecords", patientRecords);

        return "UserPage";
    }
}
