package com.khoders.smartchurch.services;

import com.khoders.smartchurch.entities.Position;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PositionService {
    List<Position> findAll();

    Position save(Position position);

    Optional<Position> findEntityById(String id);

    void delete(String id);
}
