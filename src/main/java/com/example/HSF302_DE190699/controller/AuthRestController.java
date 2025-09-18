package com.example.HSF302_DE190699.controller;

import com.example.HSF302_DE190699.entity.Account;
import com.example.HSF302_DE190699.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {
        String phone = payload.get("phone");
        String password = payload.get("password");

        Account account = accountRepository.findByPhone(phone).orElse(null);

        if (account == null || !account.getPassword().equals(password)) {
            return ResponseEntity.badRequest().body("Invalid phone or password");
        }

        if (account.getRoleID() != 1 && account.getRoleID() != 3) {
            return ResponseEntity.status(403).body("Access denied");
        }

        // có thể lưu session hoặc trả JWT ở đây
        return ResponseEntity.ok(account);
    }
}
