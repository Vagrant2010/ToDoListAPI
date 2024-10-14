package com.demarco.ToDoListAPI.service;

import com.demarco.ToDoListAPI.entity.Obligation;
import com.demarco.ToDoListAPI.repository.ObligationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObligationService {
    private final ObligationRepository obligationRepository;

    public Obligation createOb() {
        Obligation ob = new Obligation();
        obligationRepository.save(ob);
        return ob;
    }

    public Obligation createOb(String activity, String description) {
        Obligation ob = new Obligation(activity, description);
        obligationRepository.save(ob);
        return ob;
    }
}
