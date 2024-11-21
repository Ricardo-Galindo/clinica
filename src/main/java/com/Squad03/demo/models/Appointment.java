package com.Squad03.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Table(name = "Appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pacient_id", nullable = false,referencedColumnName = "id")
    private User pacient;

    @ManyToOne
    @JoinColumn(name = "responsible_id", nullable = false,referencedColumnName = "id")
    private User responsible;

    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false, referencedColumnName = "id")
    private User student;

    @Column(nullable = false,length = 30)
    private String schedule;

    @Column(nullable = true,length = 255)
    private String observations;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private AppointmentStatus status = AppointmentStatus.PENDING;

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private CreatedByType createdBy;

    public enum CreatedByType{
        RECEPCIONISTA,
        PACIENTE
    }

    public enum AppointmentStatus{
        CONFIRMED,
        PENDING,
        CANCELLED
    }

    public CreatedByType getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedByType created_by) {
        this.createdBy = created_by;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public UUID getId() {
        return id;
    }


    public User getPacient() {
        return pacient;
    }

    public void setPacient(User pacient) {
        this.pacient = pacient;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
