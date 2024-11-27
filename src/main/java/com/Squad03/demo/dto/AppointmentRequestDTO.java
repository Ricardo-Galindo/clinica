package com.Squad03.demo.dto;

import com.Squad03.demo.models.Appointment;

import java.util.UUID;

public record AppointmentRequestDTO(UUID responsibleId, UUID pacientId, UUID studentId,
                                    String observations, Appointment.CreatedByType createdBY,Appointment.AppointmentStatus status, UUID treatmentTypeId) {}