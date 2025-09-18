package com.example.HSF302_DE190699.repository;

import com.example.HSF302_DE190699.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByPhone(String phone);
}