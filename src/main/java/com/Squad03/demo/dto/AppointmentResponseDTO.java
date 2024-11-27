package com.Squad03.demo.dto;

import com.Squad03.demo.models.Appointment;
import com.Squad03.demo.models.TreatmentType;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentResponseDTO(UUID appointmentID, UUID pacientID, String pacientName, UUID responsibleID,
                                     String responsibleName, UUID studentID, String studentName, LocalDateTime schedule, String observations , Appointment.CreatedByType createdBy,
                                     Appointment.AppointmentStatus status, TreatmentType treatmentType) {}
