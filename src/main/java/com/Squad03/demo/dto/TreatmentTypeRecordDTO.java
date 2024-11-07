package com.Squad03.demo.dto;

import java.util.UUID;

public class TreatmentTypeRecordDTO {

    private UUID treatmentTypeId;
    private UUID responsibleId;
    private UUID studentId;

    public UUID getTreatmentTypeId() {
        return treatmentTypeId;
    }

    public void setTreatmentTypeId(UUID treatmentTypeId) {
        this.treatmentTypeId = treatmentTypeId;
    }

    public UUID getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(UUID responsibleId) {
        this.responsibleId = responsibleId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "TreatmentTypeRecordDTO{" +
                "treatmentTypeId=" + treatmentTypeId +
                ", responsibleId=" + responsibleId +
                ", studentId=" + studentId +
                '}';
    }
}
