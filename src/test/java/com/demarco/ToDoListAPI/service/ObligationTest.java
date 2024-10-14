package com.demarco.ToDoListAPI.service;

import com.demarco.ToDoListAPI.entity.Obligation;
import com.demarco.ToDoListAPI.repository.ObligationRepository;
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
public class ObligationTest {
    @Mock
    ObligationRepository obligationRepository;

    @InjectMocks
    private ObligationService obligationService;

    Obligation obligation;

    @Test
    public void testCreateObligation() {
        obligation = obligationService.createOb();
        when(obligationRepository.findById(1L)).thenReturn(Optional.of(obligation));
        Optional<Obligation> obligationExpected = obligationRepository.findById(1L);
        assertTrue(obligationExpected.isPresent());
        Obligation obligationActual = obligationExpected.get();
        assertEquals(obligation.getId(), obligationActual.getId());
    }

    @Test
    public void testCreateObligationWithArgs(){
        obligation = obligationService.createOb("bisogna provare","questa è una prova");
        when(obligationRepository.findById(1L)).thenReturn(Optional.of(obligation));
        Optional<Obligation> obligationExpected = obligationRepository.findById(1L);
        assertTrue(obligationExpected.isPresent());
        assertEquals(obligation.getId(), obligationExpected.get().getId());
    }

}
