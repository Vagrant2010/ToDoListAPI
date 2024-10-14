package com.demarco.ToDoListAPI.repository;

import com.demarco.ToDoListAPI.entity.Obligation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ObligationRepository extends JpaRepository<Obligation, Integer> {
    Optional<Obligation> findById(long id);
}
