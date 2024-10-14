package com.demarco.ToDoListAPI.service;

import com.demarco.ToDoListAPI.entity.ToDoList;
import com.demarco.ToDoListAPI.repository.ToDoListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ToDoListTest {
    @Mock
    ToDoListRepository toDoListRepository;

    @InjectMocks
    ToDoListService service;


    ToDoList toDoList;

    @Test
    public void testCreateToDoList() {
        toDoList  = service.createToDoList();
        when(toDoListRepository.findById(1L)).thenReturn(Optional.of(toDoList));
        Optional<ToDoList> createdToDoList = toDoListRepository.findById(1L);
        boolean present = createdToDoList.isPresent();
        assertTrue(present);
        ToDoList getCreatedToDoList = createdToDoList.get();
        assertEquals(toDoList.getId(),getCreatedToDoList.getId());
    }

    @Test
    public void testToCreateToDoListWithName(){
        ToDoList expected = service.createToDoList("Prova");
        assertEquals("Prova",expected.getName());
    }

    @Test
    public void testToGetName() throws Exception {
        ToDoList expected = new ToDoList(1,"Prova");
        when(toDoListRepository.findById(1L)).thenReturn(Optional.of(expected));
        String actual = service.getClassName(1L);
        assertEquals("Prova",actual);
    }



}
