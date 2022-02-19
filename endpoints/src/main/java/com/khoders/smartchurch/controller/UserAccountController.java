package com.khoders.smartchurch.controller;

import com.khoders.smartchurch.dto.UserAccountDto;
import com.khoders.smartchurch.impl.UserAccountServiceImpl;
import com.khoders.smartchurch.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/auth")
public class UserAccountController {
    private final UserAccountServiceImpl userAccountService;

    public UserAccountController(UserAccountServiceImpl userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> saveUser(@RequestBody UserAccountDto dto) {
        return ApiResponse.ok("ok", dto);
    }
}
