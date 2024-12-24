package com.revatureproject01.project01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.entity.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Integer> {
    // Get all followers of a specific account
    @Query("SELECT f.follower FROM Follow f WHERE f.followed.accountId = ?1")
    List<Account> findFollowersByAccountId(Integer accountId);

    // Get all accounts followed by a specific account
    @Query("SELECT f.followed FROM Follow f WHERE f.follower.accountId = ?1")
    List<Account> findFollowingByAccountId(Integer accountId);

    boolean existsByFollowerAndFollowed(Account follower, Account followed);

    void deleteByFollower_AccountIdAndFollowed_AccountId(Integer followerId, Integer followedId);

    Follow findByFollower_AccountIdAndFollowed_AccountId(Integer followerId, Integer followedId);
}
