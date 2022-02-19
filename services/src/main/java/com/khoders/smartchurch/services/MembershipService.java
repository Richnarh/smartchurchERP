package com.khoders.smartchurch.services;

import com.khoders.smartchurch.entities.Membership;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MembershipService {
    List<Membership> findAll();

    Membership save(Membership membership);

    Optional<Membership> findEntityById(String id);

    void delete(String id);
}
