package com.revatureproject01.project01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revatureproject01.project01.entity.Account;
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
    public ResponseEntity getUsersFriends(@PathVariable Integer id) {
        Account x = new Account();
        x.setAccountId(id);
        List<Friend> friends = friendService.getUsersFriends(x);
        return ResponseEntity.status(200).body(friends);
    }

    // check if user is friends with user
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/friends/{userId1}/{userId2}")
    public ResponseEntity<String> areUsersFriends(@PathVariable Integer userId1, @PathVariable Integer userId2) {
        boolean areFriends = friendService.areUsersFriends(userId1, userId2);

        if (areFriends) {
            return ResponseEntity.ok("friends");
        } else {
            return ResponseEntity.ok("!friends");
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/friends/{userId1}/{userId2}")
    public ResponseEntity addFriend(@PathVariable Integer userId1, @PathVariable Integer userId2) {
        boolean sent = friendService.sendFriendRequest(userId1, userId2);
        return ResponseEntity.status(200).body(sent);
    }

    @GetMapping("/friends/{userId}/pending")
    public ResponseEntity getUsersPendingFriends(@PathVariable Integer userId) {
        List<Friend> requests = friendService.getPendingFriendRequests(userId);
        return ResponseEntity.status(200).body(requests);
    }

    @DeleteMapping("/friends/{friendId}")
    public ResponseEntity deleteFriendById(@PathVariable Integer friendId) {
        friendService.deleteRequestById(friendId);
        return ResponseEntity.status(200).body("success");
    }

    @PatchMapping("/friends/{friendId}")
    public ResponseEntity updateFriendRequest(@PathVariable Integer friendId, @RequestBody Integer type) {
        if (type == 1) {
            friendService.acceptFriendRequest(friendId);
        } else {
            friendService.declineFriendRequest(friendId);
        }

        return ResponseEntity.status(200).body("request updated.");
    }
}
