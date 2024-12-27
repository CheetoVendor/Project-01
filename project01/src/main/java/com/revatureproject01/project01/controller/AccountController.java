package com.revatureproject01.project01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.exceptions.UsernameExistsException;
import com.revatureproject01.project01.service.AccountService;

import DTO.AccountDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {
    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Handler for registering a user
    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody Account account) {
        try {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String hashedPassword = encoder.encode(account.getPassword());
            account.setPassword(hashedPassword);

            // Register the account in the database
            AccountDTO registeredAccount = accountService.registerAccount(account);
            // AccountDTO dto = new AccountDTO(registeredAccount);

            if (registeredAccount != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(registeredAccount);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Registration failed. Please check your input.");
            }
        } catch (UsernameExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the request");
        }
    }

    // Handler for logging in a user
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody Account account) {
        Account loggedAccount = accountService.loginAccount(account);

        AccountDTO dto = new AccountDTO(loggedAccount);

        if (loggedAccount != null) {
            return ResponseEntity.status(200).body(dto);
        } else {
            return ResponseEntity.status(401).body("login failed!");
        }
    }

    // Handler for editing profile
    @PatchMapping("/profile/{accountId}")
    public ResponseEntity updateProfile(@RequestBody Account account) {
        Account updatedAccount = accountService.updateAccountById(account);

        AccountDTO dto = new AccountDTO(updatedAccount);
        return ResponseEntity.status(200).body(dto);
    }

    // Handler for getting profile by id
    @GetMapping("/profile/{accountId}")
    public ResponseEntity getProfileById(@PathVariable Integer accountId) {
        Account account = accountService.getAccountById(accountId);

        AccountDTO dto = new AccountDTO(account);
        if (account != null) {
            return ResponseEntity.status(200).body(dto);
        } else {
            return ResponseEntity.status(404).body("profile could not be found");
        }
    }

}
