package com.Squad03.demo.controllers;

import com.Squad03.demo.dto.AppointmentRequestDTO;
import com.Squad03.demo.dto.AppointmentResponseDTO;
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
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@Valid @RequestBody AppointmentRequestDTO appointmentRequest) {
        Appointment newAppointment = appointmentService.saveAppointment(appointmentRequest);
        AppointmentResponseDTO dto = appointmentService.convertToResponseDTO(newAppointment);
        return  ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> getAppointmentById(@PathVariable UUID id){
        Appointment currentAppointment = appointmentService.getAppointmentById(id);
        AppointmentResponseDTO dto = appointmentService.convertToResponseDTO(currentAppointment);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointments() {
        List<AppointmentResponseDTO> allAppointments = appointmentService.getAllAppointments();
        return ResponseEntity.status(HttpStatus.OK).body(allAppointments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> updateAppointment(@PathVariable UUID id, @Valid @RequestBody AppointmentRequestDTO appointmentRequest) {
        Appointment updatedAppointment = appointmentService.updateAppointmentById(id, appointmentRequest);
        AppointmentResponseDTO dto = appointmentService.convertToResponseDTO(updatedAppointment);
        return  ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointmentById(@PathVariable UUID id) throws Exception {
        appointmentService.deleteAppointmentById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Consulta com ID: " + id + " foi excluída com sucesso!");
    }
}