package com.khoders.smartchurch.repository;

import com.khoders.smartchurch.entities.Membership;
import com.khoders.smartchurch.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, UUID> {
}
