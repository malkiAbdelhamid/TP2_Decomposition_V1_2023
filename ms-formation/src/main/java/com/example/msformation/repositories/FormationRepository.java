package com.example.msformation.repositories;

import com.example.msformation.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Long> {
}