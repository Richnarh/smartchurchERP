package com.khoders.smartchurch.impl;

import com.khoders.smartchurch.MembershipRepository;
import com.khoders.smartchurch.entities.Membership;
import com.khoders.smartchurch.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MembershipServiceImpl implements MembershipService
{
    @Autowired
    MembershipRepository membershipRepository;

    @Override
    public List<Membership> findAll() {
        return membershipRepository.findAll();
    }

    @Override
    public Membership save(Membership membership) {
        return membershipRepository.save(membership);
    }

    @Override
    public Optional<Membership> findEntityById(String id)
    {
        if(membershipRepository.findById(id).isPresent()){
            return membershipRepository.findById(id);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        try
        {
            Optional<Membership> membership = membershipRepository.findById(id);
            membership.ifPresent(value -> membershipRepository.delete(value));
         }catch (Exception e)
         {
            e.printStackTrace();
         }
    }
}
