package com.revatureproject01.project01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revatureproject01.project01.entity.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
    List<Friend> findByFrienderIdOrFriendedIdAndFriendStatus(Integer userIdFriender, Integer userIdFriended,
            Integer friendStatus);

    List<Friend> findByFrienderIdAndFriendStatus(Integer userIdFriender, Integer friendStatus);
}
