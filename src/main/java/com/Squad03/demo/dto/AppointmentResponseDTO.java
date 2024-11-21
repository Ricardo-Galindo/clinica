package com.Squad03.demo.dto;

import com.Squad03.demo.models.Appointment;

import java.util.UUID;

public record AppointmentResponseDTO(UUID appointmentID, UUID pacientID, String pacientName, UUID responsibleID,
                                     String responsibleName, UUID studentID, String studentName, String schedule, String observations , Appointment.CreatedByType createdBy,
                                     Appointment.AppointmentStatus status) {}
