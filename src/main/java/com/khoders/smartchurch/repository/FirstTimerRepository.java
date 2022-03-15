package com.khoders.smartchurch.repository;

import com.khoders.smartchurch.entities.FirstTimer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FirstTimerRepository extends JpaRepository<FirstTimer, UUID> {
}
