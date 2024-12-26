package com.revatureproject01.project01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revatureproject01.project01.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);

    Account findByUsernameAndPassword(String username, String password);

    List<Account> findByUsernameContainingIgnoreCase(String username);
}
