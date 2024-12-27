package com.revatureproject01.project01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revatureproject01.project01.service.SearchService;

import DTO.AccountDTO;
import DTO.PostDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/search")
public class SearchController {
    SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    // Searches for accounts using a search string
    @GetMapping("/accounts/{searchString}")
    public ResponseEntity searchAccounts(@PathVariable String searchString) {
        List<AccountDTO> accountsList = new ArrayList<>();
        accountsList = searchService.searchUsernames(searchString);
        return ResponseEntity.status(200).body(accountsList);
    }

    // searches for posts using a search string
    @GetMapping("/posts/{searchString}")
    public ResponseEntity searchPosts(@PathVariable String searchString) {
        List<PostDTO> postsList = new ArrayList<>();
        postsList = searchService.searchPostsByString(searchString);
        return ResponseEntity.status(200).body(postsList);
    }
}
