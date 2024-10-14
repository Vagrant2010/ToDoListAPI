package com.demarco.ToDoListAPI.service;

import com.demarco.ToDoListAPI.entity.ToDoList;
import com.demarco.ToDoListAPI.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoListService {
    private final ToDoListRepository toDoListRepository;

    public ToDoList createToDoList() {
        ToDoList toDoList = new ToDoList();
        toDoListRepository.save(toDoList);
        return toDoList;
    }

    public ToDoList createToDoList(String name) {
        ToDoList toDoList = new ToDoList(name);
        toDoListRepository.save(toDoList);
        return toDoList;
    }

    public String getClassName(long id) throws Exception {
        Optional<ToDoList> toDoListOptional = toDoListRepository.findById(id);
        if (toDoListOptional.isPresent()) {
            return toDoListOptional.get().getName();
        }
        throw new Exception("To do list is not present!");
    }
}