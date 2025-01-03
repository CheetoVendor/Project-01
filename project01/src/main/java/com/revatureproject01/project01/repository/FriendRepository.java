package com.revatureproject01.project01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.entity.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
    List<Friend> findByFrienderOrFriendedAndFriendStatus(Account friender, Account friended, Integer friendStatus);

    boolean existsByFriender_AccountIdAndFriended_AccountIdAndFriendStatus(Integer frienderId, Integer friendedId,
            Integer friendStatus);

    List<Friend> findByFriendedAndFriendStatus(Account friended, Integer friendStatus);

    Friend findByFriendId(Integer friendId);

    Friend findByFriender_AccountIdAndFriended_AccountId(Integer id1, Integer id2);
}
