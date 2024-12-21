package com.revatureproject01.project01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revatureproject01.project01.entity.Friend;
import com.revatureproject01.project01.service.FriendService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FriendController {
    FriendService friendService;

    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/friends/{id}")
    public ResponseEntity getUsersFriends(@PathVariable Integer userId) {
        List<Friend> friends = friendService.getFriends(userId);
        return ResponseEntity.status(200).body(friends);
    }
}
