package com.Squad03.demo.dto;

import java.util.UUID;

public record TreatmentTypeRecordRequestDTO(UUID treatmentTypeId, UUID responsibleId, UUID studentId){}