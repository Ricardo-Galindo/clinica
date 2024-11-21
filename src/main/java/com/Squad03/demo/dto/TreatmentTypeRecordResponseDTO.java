package com.Squad03.demo.dto;

import com.Squad03.demo.models.TreatmentType;

import java.util.UUID;

public record TreatmentTypeRecordResponseDTO(UUID TreatmentTypeRecordId, TreatmentType treatmentType,
                                             UUID responsibleID, String responsibleName,
                                             UUID studentID, String studentName) {
}
