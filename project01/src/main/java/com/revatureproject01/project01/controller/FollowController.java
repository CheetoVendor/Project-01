package com.revatureproject01.project01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    // Gets followers for a user
    @GetMapping("/followers/{accountId}")
    public List<Account> getUsersFollowers(@PathVariable Integer accountId) {
        return followservice.getFollowers(accountId);
    }

    // gets people a user is following
    @GetMapping("/followed/{accountId}")
    public List<Account> getUsersFollowed(@PathVariable Integer accountId) {
        return followservice.getFollowing(accountId);
    }

    // returns whether or not a user is following a specific user
    @GetMapping("/followers/{userId1}/{userId2}")
    public boolean isUserFollowing(@PathVariable Integer userId1, @PathVariable Integer userId2) {
        Account x = new Account();
        x.setAccountId(userId1);
        Account y = new Account();
        y.setAccountId(userId2);

        return followservice.isFollowed(x, y);
    }

    // unfollows a user
    @DeleteMapping("/followed/{userId}/{unfollowId}")
    public ResponseEntity unfollowUser(@PathVariable Integer userId, @PathVariable Integer unfollowId) {
        int x = followservice.removeFollow(userId, unfollowId);
        return ResponseEntity.status(200).body(x);
    }

    // UserID1 FOLLOWS UserId2
    @PostMapping("/follow/{userId1}/{userId2}")
    public ResponseEntity followUser(@PathVariable Integer userId1, @PathVariable Integer userId2) {
        Follow follow = new Follow();
        Account x = new Account();
        x.setAccountId(userId1);
        follow.setFollower(x);

        Account y = new Account();
        y.setAccountId(userId2);
        follow.setFollowed(y);

        Follow returned = followservice.createFollow(follow);
        return ResponseEntity.status(200).body(returned);
    }
}
