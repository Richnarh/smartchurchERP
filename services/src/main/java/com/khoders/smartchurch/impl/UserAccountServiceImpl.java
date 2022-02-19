package com.khoders.smartchurch.impl;

import com.khoders.smartchurch.entities.UserAccount;
import com.khoders.smartchurch.services.UserAccountService;

import java.util.List;
import java.util.Optional;


public class UserAccountServiceImpl implements UserAccountService {
    @Override
    public List<UserAccount> findAll() {
        return null;
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return null;
    }

    @Override
    public Optional<UserAccount> findEntityById(String id) {
        return Optional.empty();
    }

    @Override
    public void delete(String id) {

    }
}
