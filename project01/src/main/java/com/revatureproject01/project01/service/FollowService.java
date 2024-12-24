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

    // get followers
    public List<Account> getFollowers(Integer account) {
        return followRepository.findFollowersByAccountId(account);
    }

    // get accounts a user is following
    public List<Account> getFollowing(Integer accountId) {
        return followRepository.findFollowingByAccountId(accountId);
    }

    // delete follow
    public Integer removeFollow(Integer userId, Integer unfollowId) {
        Follow follow = followRepository.findByFollower_AccountIdAndFollowed_AccountId(userId, unfollowId);
        if (follow == null) {
            return 0;
        } else {
            followRepository.delete(follow);
            return 1;
        }
    }

    public boolean isFollowed(Account follower, Account followed) {
        return followRepository.existsByFollowerAndFollowed(follower, followed);
    }

}
