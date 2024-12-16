package com.revatureproject01.project01.service;

import java.util.Optional;

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

    // TODO - Log in account
    public Account loginAccount(Account account) {
        Account loggedAccount = accountRepository.findByUsernameAndPassword(account.getUsername(),
                account.getPassword());
        if (loggedAccount != null) {
            return loggedAccount;
        } else {
            return null;
        }
    }

    // TODO - get account by id
    public Account getAccountById(Integer id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            return accountOptional.get();
        } else {
            return null;
        }
    }

    // TODO - EDIT ACCOUNT BY ID
    public Account updateAccountById(Account account) {
        return accountRepository.save(account);

    }

    // Checks of username exists in the database
    public boolean usernameExists(String username) {
        Account accountOptional = accountRepository.findByUsername(username);
        if (accountOptional != null) {
            return true;
        } else {
            return false;
        }
    }
}
