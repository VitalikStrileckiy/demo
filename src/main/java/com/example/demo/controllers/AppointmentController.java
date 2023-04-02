package com.example.demo.controllers;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.entity.Dentist;
import com.example.demo.entity.Journal;
import com.example.demo.repo.DentistRepository;
import com.example.demo.repo.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppointmentController {

    @Autowired
    private JournalRepository journalRepo;

    @Autowired
    private DentistRepository dentistRepo;

    @GetMapping("/appointment")
    public String appointment(Model model) {
        model.addAttribute("dentists", dentistRepo.findByActive(true));
        model.addAttribute("appointmentData", new AppointmentDto());
        return "RecordDentist";
    }

    @PostMapping("/saveAppointment")
    public String saveAppointment(AppointmentDto appointmentData) {

        final Journal journal = new Journal();
        journal.setDate(appointmentData.getDate());
        journal.setDentist(dentistRepo.findById(appointmentData.getDentistId()).get());
        journal.setService(appointmentData.getService());
        journal.setPatient(appointmentData.getUser());

        journalRepo.save(journal);

        return "redirect:/UserPage";
    }

    @GetMapping("/dentists")
    public String  showDentists(Model model) {
        model.addAttribute("dentists", dentistRepo.findByActive(true));
        return "Dentists";
    }

}
