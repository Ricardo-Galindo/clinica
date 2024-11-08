package com.Squad03.demo.models;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Treatment_type_records")
public class TreatmentTypeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "treatment_type_id", nullable = false, referencedColumnName = "id")
    private TreatmentType treatmentType;

    @ManyToOne
    @JoinColumn(name = "responsible_id", nullable = false, referencedColumnName = "id")
    private User responsible;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false, referencedColumnName = "id")
    private User student;

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
    }

    public UUID getId() {
        return id;
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

    public void setId(UUID id) {

    }
}

