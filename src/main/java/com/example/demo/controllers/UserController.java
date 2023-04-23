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
import java.util.Calendar;
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
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        final List<Journal> patientRecords = journalRepo.findPatientRecords(patient.getId(), calendar.getTime());

        model.addAttribute("patientRecords", patientRecords);

        return "UserPage";
    }
}
