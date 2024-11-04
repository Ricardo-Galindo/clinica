package com.Squad03.demo.controllers;

import com.Squad03.demo.dto.AppointmentRequest;
import com.Squad03.demo.models.Appointment;
import com.Squad03.demo.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable UUID id){
        Appointment currentAppointment = appointmentService.getAppointmentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(currentAppointment);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> allAppointments = appointmentService.getAllAppointments();
        return ResponseEntity.status(HttpStatus.OK).body(allAppointments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable UUID id, @Valid @RequestBody AppointmentRequest appointmentRequest) {
        Appointment updatedAppointment = appointmentService.updateAppointmentById(id, appointmentRequest);
        return  ResponseEntity.status(HttpStatus.OK).body(updatedAppointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointmentById(@PathVariable UUID id) throws Exception {
        appointmentService.deleteAppointmentById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Consulta com ID: " + id + " foi excluída com sucesso!");
    }
}