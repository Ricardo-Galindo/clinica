package com.Squad03.demo.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
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

    @Column(nullable = true)
    private String created_by;

    public String getCreatedBy() {
        return created_by;
    }

    public void setCreatedBy(String created_by) {
        this.created_by = created_by;
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
