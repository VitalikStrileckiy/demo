package com.example.demo.controllers;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.entity.Journal;
import com.example.demo.repo.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppointmentController {

    @Autowired
    private JournalRepository journalRepo;

    @GetMapping("/appointment")
    public String appointment(Model model){

        return "RecordDentist";
    }

    @PostMapping("/saveAppointment")
    public String saveAppointment(AppointmentDto appointmentData) {

        final Journal journal = new Journal();
        journal.setDate(appointmentData.getDate());
        journal.setDentist(appointmentData.getDentist());
        journal.setService(appointmentData.getService());
        journal.setPatient(appointmentData.getUser());

        journalRepo.save(journal);

        return "redirect:/UserPage";
    }

}
