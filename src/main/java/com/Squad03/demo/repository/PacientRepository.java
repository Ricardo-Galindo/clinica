package com.Squad03.demo.repository;
import com.Squad03.demo.model.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PacientRepository extends JpaRepository<Pacient, Long> {

}

