package com.revatureproject01.project01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.exceptions.UsernameExistsException;
import com.revatureproject01.project01.service.AccountService;

@RestController
public class AccountController {
    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // #region Account Region

    // Handler for registering a user
    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody Account account) {
        try {
            Account registeredAccount = accountService.registerAccount(account);
            // if account isnt null return success with account, else return status 400
            if (registeredAccount != null) {
                return ResponseEntity.status(200).body(registeredAccount);
            } else {
                return ResponseEntity.status(400).body("unsuccessful");
            }
        } catch (UsernameExistsException e) {
            return ResponseEntity.status(409).body("Username exists");
        }
    }

    // TODO - LOG IN USER
    // Handler for logging in a user
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody Account account) {
        Account loggedAccount = accountService.loginAccount(account);
        if (loggedAccount != null) {
            return ResponseEntity.status(200).body(loggedAccount);
        } else {
            return ResponseEntity.status(401).body("login failed!");
        }
    }

    // TODO - EDIT PROFILE
    // Handler for editing profile
    @PatchMapping("/profile/{accountId}")
    public ResponseEntity updateProfile(@RequestBody Account account) {
        Account updatedAccount = accountService.updateAccountById(account);
        return ResponseEntity.status(200).body(updatedAccount);
    }

    // TODO - VIEW PROFILE
    // Handler for getting profile by id
    @GetMapping("/profile/{accountId}")
    public ResponseEntity getProfileById(@PathVariable Integer accountId) {
        Account account = accountService.getAccountById(accountId);
        if (account != null) {
            return ResponseEntity.status(200).body(account);
        } else {
            return ResponseEntity.status(404).body("profile could not be found");
        }
    }

    // #endregion
}
