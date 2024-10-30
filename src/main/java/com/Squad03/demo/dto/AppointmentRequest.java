package com.Squad03.demo.dto;

import java.util.UUID;

public class AppointmentRequest {

   private UUID responsibleId;

   private UUID pacientId;

   private UUID studentId;

   private String schedule;

   private String observations;

   private String createdBy;

    public UUID getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(UUID responsibleId) {
        this.responsibleId = responsibleId;
    }

    public UUID getPacientId() {
        return pacientId;
    }

    public void setPacientId(UUID pacientId) {
        this.pacientId = pacientId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "AppointmentRequest{" +
                "responsibleId=" + responsibleId +
                ", pacientId=" + pacientId +
                ", studentId=" + studentId +
                ", schedule='" + schedule + '\'' +
                ", observations='" + observations + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
