package com.revatureproject01.project01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.entity.Post;
import com.revatureproject01.project01.repository.AccountRepository;
import com.revatureproject01.project01.repository.PostRepository;

import DTO.AccountDTO;
import DTO.PostDTO;

@Service
public class SearchService {
    PostRepository postRepository;
    AccountRepository accountRepository;

    @Autowired
    public SearchService(PostRepository postRepository, AccountRepository accountRepository) {
        this.postRepository = postRepository;
        this.accountRepository = accountRepository;
    }

    // Searches posts by a search string
    public List<PostDTO> searchPostsByString(String searchText) {
        List<Post> posts = postRepository.findByPostTextContainingIgnoreCase(searchText);
        List<PostDTO> dtos = new ArrayList<>();
        for (Post post : posts) {
            dtos.add(new PostDTO(post));
        }
        return dtos;
    }

    // searches db with a searchstring
    public List<AccountDTO> searchUsernames(String searchString) {
        List<Account> searchedAccounts = accountRepository.findByUsernameContainingIgnoreCase(searchString);
        List<AccountDTO> accounts = new ArrayList<>();

        if (searchedAccounts.size() > 0) {
            // iterate through accounts to return dtos
            for (Account account : searchedAccounts) {
                accounts.add(new AccountDTO(account));
            }
            return accounts;
        } else {
            return null;
        }
    }
}
