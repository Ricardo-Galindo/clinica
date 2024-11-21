package com.Squad03.demo.repository;

import com.Squad03.demo.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

}
