package com.revatureproject01.project01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.entity.Friend;
import com.revatureproject01.project01.repository.FriendRepository;

@Service
public class FriendService {

    FriendRepository friendRepository;
    AccountService accountService;

    @Autowired
    public FriendService(FriendRepository friendRepository, AccountService accountService) {
        this.friendRepository = friendRepository;
        this.accountService = accountService;
    }

    // gets friends a user has
    public List<Friend> getUsersFriends(Account x) {
        return friendRepository.findByFrienderOrFriendedAndFriendStatus(x, x, 1);
    }

    // returns whether user a and b or friends
    public boolean areUsersFriends(Integer userId1, Integer userId2) {
        return friendRepository.existsByFriender_AccountIdAndFriended_AccountIdAndFriendStatus(userId1, userId2, 1) ||
                friendRepository.existsByFriender_AccountIdAndFriended_AccountIdAndFriendStatus(userId2, userId1, 1);
    }

    // sends a friend request in status 1 (pending)
    public boolean sendFriendRequest(Integer userId1, Integer userId2) {
        if (userId1 == userId2) {
            return false;
        }

        Friend request = new Friend();
        request.setFriended(accountService.getAccountById(userId2));
        request.setFriender(accountService.getAccountById(userId2));

        request.setFriendStatus(0);
        request.setTimeCreatedEpoch(System.currentTimeMillis());

        return true;

    }

    // returns friend requests in status 1 (pending)
    public List<Friend> getPendingFriendRequests(Integer userId) {
        Account x = new Account();
        x.setAccountId(userId);

        return friendRepository.findByFriendedAndFriendStatus(x, 0);
    }

    // deletes a friend request
    public void deleteRequestById(Integer friendId) {
        Friend x = new Friend();
        x.setFriendId(friendId);
        friendRepository.delete(x);
    }

    // accepts a friend request and puts to status 1 (accepted)
    public Friend acceptFriendRequest(Integer friendId) {
        Friend friend = friendRepository.findByFriendId(friendId);
        friend.setFriendStatus(1);
        friendRepository.save(friend);
        return friend;
    }

    // declines a friend request and puts to status 0 (denied)
    public void declineFriendRequest(Integer friendId) {
        Friend friend = friendRepository.findByFriendId(friendId);
        friend.setFriendStatus(0);
        friendRepository.save(friend);
    }

    // deletes a friend
    public boolean deleteFriend(Integer userId1, Integer userId2) {
        Friend friend = friendRepository.findByFriender_AccountIdAndFriended_AccountId(userId1, userId2);
        if (friend == null) {
            friend = friendRepository.findByFriender_AccountIdAndFriended_AccountId(userId2, userId1);
        }
        if (friend != null) {
            friendRepository.delete(friend);
            return true;
        } else {
            return false;
        }
    }
}
