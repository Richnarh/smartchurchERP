package com.khoders.smartchurch.services;

import com.khoders.smartchurch.entities.Branch;
import com.khoders.smartchurch.entities.Position;
import com.khoders.smartchurch.repository.BranchRepository;
import com.khoders.smartchurch.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BranchService {
    private final BranchRepository repository;
    private BranchService(BranchRepository repository){
        this.repository=repository;
    }
    public List<Branch> findAll() {
        return repository.findAll();
    }

    public Branch save(Branch position) {
        return repository.save(position);
    }

    public Branch findEntityById(UUID id) {
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
