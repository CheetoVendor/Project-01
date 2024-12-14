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

    // TODO - EDIT ACCOUNT BY ID
    public int updateAccountById(Account account) {
        // get basic logic first
        Optional<Account> optionalAccount = accountRepository.findById(account.getAccountId());

        if (optionalAccount.isPresent()) {
            Account accountToUpdate = optionalAccount.get();

            accountToUpdate.setBioText(account.getBioText());
            accountToUpdate.setProfilePicture(account.getProfilePicture());

            accountRepository.save(accountToUpdate);
            return 1;
        } else {
            return 0;
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
}
