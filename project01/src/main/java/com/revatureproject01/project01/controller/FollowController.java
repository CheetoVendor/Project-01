package com.revatureproject01.project01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.entity.Follow;
import com.revatureproject01.project01.service.FollowService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FollowController {
    FollowService followservice;;

    @Autowired
    public FollowController(FollowService followService) {
        this.followservice = followService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/followers/{id}")
    public ResponseEntity getUsersFollowers(@PathVariable Integer id) {
        Account x = new Account();
        x.setAccountId(id);
        List<Follow> follows = followservice.getAccountsFollowing(x);
        return ResponseEntity.status(200).body(follows);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/followed/{id}")
    public ResponseEntity getUsersFollowed(@PathVariable Integer id) {
        Account x = new Account();
        x.setAccountId(id);

        List<Follow> follows = followservice.getAccountsFollowing(x);
        return ResponseEntity.status(200).body(follows);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/followers/{userId1}/{userId2}")
    public boolean isUserFollowing(@PathVariable Integer id, @PathVariable Integer id2) {
        Account x = new Account();
        x.setAccountId(id);
        Account y = new Account();
        y.setAccountId(id2);

        return followservice.isFollowed(y, y);
    }
}
