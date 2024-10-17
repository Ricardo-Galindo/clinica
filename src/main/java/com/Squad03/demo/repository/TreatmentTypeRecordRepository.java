package com.Squad03.demo.repository;

import com.Squad03.demo.models.TreatmentTypeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TreatmentTypeRecordRepository extends JpaRepository<TreatmentTypeRecord, UUID> {
}
