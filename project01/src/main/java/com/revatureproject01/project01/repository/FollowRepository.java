package com.revatureproject01.project01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.entity.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Integer> {
    List<Follow> findByFollower(Account follower);

    List<Follow> findByFollowed(Account followed);

    boolean existsByFollowerAndFollowed(Account follower, Account followed);
}
