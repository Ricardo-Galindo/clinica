package com.Squad03.demo.dto;

import java.util.UUID;

public record AppointmentRequest( UUID responsibleId, UUID pacientId, UUID studentId, String schedule, String observations, String createdBY) {}