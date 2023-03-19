package com.example.demo.dto;

import com.example.demo.entity.Dentist;
import com.example.demo.entity.Patient;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDto {

    //Date and time
    private Date date;

    // Послуга
    private String service;

    // Стоматолог
    private Dentist dentist;

    // ID клієнта (пізніше будеш витягати з security
    private Patient user;


}
