package com.khoders.smartchurch.services;

import com.khoders.smartchurch.entities.FirstTimer;
import com.khoders.smartchurch.entities.Position;
import com.khoders.smartchurch.repository.FirstTimerRepository;
import com.khoders.smartchurch.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FirstTimerService {
    private final FirstTimerRepository repository;
    private FirstTimerService(FirstTimerRepository repository){
        this.repository=repository;
    }
    public List<FirstTimer> findAll() {
        return repository.findAll();
    }

    public FirstTimer save(FirstTimer firstTimer) {
        return repository.save(firstTimer);
    }

    public FirstTimer findEntityById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(UUID id) {
        try
        {
            repository.findById(id).ifPresent(repository::delete);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
