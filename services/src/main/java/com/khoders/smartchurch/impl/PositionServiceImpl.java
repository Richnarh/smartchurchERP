package com.khoders.smartchurch.impl;

import com.khoders.smartchurch.entities.Position;
import com.khoders.smartchurch.PositionRepository;
import com.khoders.smartchurch.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PositionServiceImpl implements PositionService {

    @Autowired private PositionRepository repository;

    @Override
    public List<Position> findAll() {
        return repository.findAll();
    }

    @Override
    public Position save(Position position) {
        return repository.save(position);
    }

    @Override
    public Optional<Position> findEntityById(String id) {
       if(repository.findById(id).isPresent()){
            return repository.findById(id);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        try
        {
            Optional<Position> membership = repository.findById(id);
            if(membership != null)
            {
                repository.deleteEntity(membership);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
