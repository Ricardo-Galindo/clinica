package com.Squad03.demo.controllers;

import com.Squad03.demo.dto.AppointmentRequest;
import com.Squad03.demo.models.Appointment;
import com.Squad03.demo.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@Valid @RequestBody AppointmentRequest appointmentRequest) {
        Appointment newAppointment = appointmentService.saveAppointment(appointmentRequest);
        return  ResponseEntity.status(HttpStatus.OK).body(newAppointment);
    }
}
