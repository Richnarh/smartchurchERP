package com.khoders.smartchurch;

import com.khoders.smartchurch.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, String> {
    void deleteEntity(Optional<Position> position);
}
