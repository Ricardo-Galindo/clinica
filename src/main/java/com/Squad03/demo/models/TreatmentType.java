package com.Squad03.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "Treatment_types")
public class TreatmentType {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    @NotBlank()
    private String type;

    @Column(nullable = false)
    @NotBlank()
    private String schedule;

    @OneToOne(mappedBy = "treatmentType",cascade = CascadeType.ALL)
    private Appointment appointment;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
