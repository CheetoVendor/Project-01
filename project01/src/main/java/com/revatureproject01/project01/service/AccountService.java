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

    // registers an account
    public Account registerAccount(Account account) throws UsernameExistsException {
        if (!usernameExists(account.getUsername())) {
            return accountRepository.save(account);
        } else {
            throw new UsernameExistsException("Username already exists!");
        }
    }

    // logs in account
    public Account loginAccount(Account account) {
        Account loggedAccount = accountRepository.findByUsernameAndPassword(account.getUsername(),
                account.getPassword());
        if (loggedAccount != null) {
            return loggedAccount;
        } else {
            return null;
        }
    }

    // Gets account by ID
    public Account getAccountById(Integer id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            return accountOptional.get();
        } else {
            return null;
        }
    }

    // edits account by Id
    public Account updateAccountById(Account account) {
        Optional<Account> optional = accountRepository.findById(account.getAccountId());
        if (optional.isPresent()) {
            Account update = optional.get();
            update.setBioText(account.getBioText());
            update.setUsername(account.getUsername());
            return accountRepository.save(update);
        } else {
            return null;
        }

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

    // finds account by username
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
