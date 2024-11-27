package com.Squad03.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @OneToOne
    @JoinColumn(name = "treatment_type_id",nullable = false,referencedColumnName = "id")
    private TreatmentType treatmentType;


    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime schedule = LocalDateTime.now();

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

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
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

    public LocalDateTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }
}
