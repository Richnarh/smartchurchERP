package com.khoders.smartchurch.services;

import com.khoders.smartchurch.entities.UserAccount;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserAccountService {
    List<UserAccount> findAll();

    UserAccount save(UserAccount userAccount);

    Optional<UserAccount> findEntityById(String id);

    void delete(String id);
}
