package com.khoders.smartchurch.services;

import com.khoders.smartchurch.entities.Membership;
import com.khoders.smartchurch.entities.Position;
import com.khoders.smartchurch.repository.MembershipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MembershipService {
    private final MembershipRepository membershipRepository;

    private MembershipService(MembershipRepository membershipRepository){
        this.membershipRepository=membershipRepository;
    }
    public List<Membership> findAll() {
        return membershipRepository.findAll();
    }
    public Membership save(Membership membership) {
        return membershipRepository.save(membership);
    }
    public Membership findEntityById(UUID id) {
        return membershipRepository.findById(id).orElse(null);
    }
    public void delete(UUID id) {membershipRepository.findById(id).ifPresent(membershipRepository::delete);}
}
