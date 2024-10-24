package com.Squad03.demo.repository;

import com.Squad03.demo.models.TreatmentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TreatmentTypeRepository extends JpaRepository<TreatmentType, UUID> {
      Optional<TreatmentType> findTreatmentTypeByType(String type);
}
