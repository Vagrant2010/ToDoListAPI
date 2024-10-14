package com.demarco.ToDoListAPI.repository;

import com.demarco.ToDoListAPI.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToDoListRepository extends JpaRepository<ToDoList, Integer> {
    Optional<ToDoList> findById(long id);
}
