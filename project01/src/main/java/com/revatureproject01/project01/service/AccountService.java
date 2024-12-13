package com.revatureproject01.project01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.exceptions.UsernameExistsException;
import com.revatureproject01.project01.repository.AccountRepository;

@Service
public class AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // TODO - Register account
    public Account registerAccount(Account account) throws UsernameExistsException {
        if (!usernameExists(account.getUsername())) {
            return accountRepository.save(account);
        } else {
            throw new UsernameExistsException("Username already exists!");
        }
    }

    // TODO - Authenticate Account

    // TODO - Log in account

    // TODO - EDIT ACCOUNT BY ID

    public boolean usernameExists(String username) {
        Account accountOptional = accountRepository.findByUsername(username);
        if (accountOptional != null) {
            return true;
        } else {
            return false;
        }
    }
}
