package com.revatureproject01.project01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.entity.Follow;
import com.revatureproject01.project01.repository.FollowRepository;

@Service
public class FollowService {
    FollowRepository followRepository;

    @Autowired
    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    // create follow
    public Follow createFollow(Follow follow) {
        return followRepository.save(follow);
    }

    // get following
    public List<Follow> getAccountsFollowing(Account account) {
        return followRepository.findByFollower(account);
    }

    // get followed by id
    public List<Follow> getAccountsFollowed(Account account) {
        return followRepository.findByFollowed(account);
    }

    // delete follow
    public void removeFollow(Follow follow) {
        followRepository.delete(follow);
    }

    public boolean isFollowed(Account follower, Account followed) {
        return followRepository.existsByFollowerAndFollowed(follower, followed);
    }

}
