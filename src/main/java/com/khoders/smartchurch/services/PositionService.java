package com.khoders.smartchurch.services;

import com.khoders.smartchurch.entities.Position;
import com.khoders.smartchurch.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PositionService {
    private final PositionRepository repository;
    private PositionService(PositionRepository repository){
        this.repository=repository;
    }
    public List<Position> findAll() {
        return repository.findAll();
    }

    public Position save(Position position) {
        return repository.save(position);
    }

    public Position findEntityById(UUID id) {
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
