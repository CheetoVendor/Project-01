package com.revatureproject01.project01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.entity.Follow;
import com.revatureproject01.project01.repository.FollowRepository;

import DTO.AccountDTO;
import DTO.FollowDTO;

@Service
public class FollowService {
    FollowRepository followRepository;

    @Autowired
    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    // create follow
    public FollowDTO createFollow(Follow follow) {
        Follow x = followRepository.save(follow);
        return new FollowDTO(x);
    }

    // get followers
    public List<AccountDTO> getFollowers(Integer account) {
        List<Account> accounts = followRepository.findFollowersByAccountId(account);
        List<AccountDTO> dtos = new ArrayList<AccountDTO>();

        for (Account a : accounts) {
            dtos.add(new AccountDTO(a));
        }
        return dtos;
    }

    // get accounts a user is following
    public List<AccountDTO> getFollowing(Integer accountId) {
        List<Account> list = followRepository.findFollowingByAccountId(accountId);
        List<AccountDTO> dtos = new ArrayList<>();

        for (Account account : list) {
            dtos.add(new AccountDTO(account));
        }
        return dtos;
    }

    // delete follow
    public Integer removeFollow(Integer userId, Integer unfollowId) {
        List<Follow> follows = followRepository.findByFollower_AccountIdAndFollowed_AccountId(userId, unfollowId);
        for (Follow follow : follows) {
            if (Objects.equals(follow.getFollowed().getAccountId(), unfollowId)
                    && Objects.equals(follow.getFollower().getAccountId(), userId)) {
                followRepository.delete(follow);
                return 1;
            }
        }
        return 0;
    }

    // returns whether user a is following user b
    public boolean isFollowed(Account follower, Account followed) {
        return followRepository.existsByFollower_AccountIdAndFollowed_AccountId(follower.getAccountId(),
                followed.getAccountId());
    }

}
