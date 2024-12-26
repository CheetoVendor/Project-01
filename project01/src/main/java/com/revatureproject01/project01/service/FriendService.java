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

    public List<Friend> getUsersFriends(Account x) {
        return friendRepository.findByFrienderOrFriendedAndFriendStatus(x, x, 1);
    }

    public boolean areUsersFriends(Integer userId1, Integer userId2) {
        return friendRepository.existsByFriender_AccountIdAndFriended_AccountIdAndFriendStatus(userId1, userId2, 1) ||
                friendRepository.existsByFriender_AccountIdAndFriended_AccountIdAndFriendStatus(userId2, userId1, 1);
    }

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

    public List<Friend> getPendingFriendRequests(Integer userId) {
        Account x = new Account();
        x.setAccountId(userId);

        return friendRepository.findByFriendedAndFriendStatus(x, 0);
    }

    public void deleteRequestById(Integer friendId) {
        Friend x = new Friend();
        x.setFriendId(friendId);
        friendRepository.delete(x);
    }

    public void acceptFriendRequest(Integer friendId) {
        Friend friend = friendRepository.findByFriendId(friendId);
        friend.setFriendStatus(1);
        friendRepository.save(friend);
    }

    public void declineFriendRequest(Integer friendId) {
        Friend friend = friendRepository.findByFriendId(friendId);
        friend.setFriendStatus(0);
        friendRepository.save(friend);
    }

    public boolean deleteFriend(Integer userId1, Integer userId2) {
        Account x = new Account();
        x.setAccountId(userId1);
        Account y = new Account();
        y.setAccountId(userId2);
        Friend friend = friendRepository.findByFrienderOrFriended(x, y);

        if (friend != null) {
            friendRepository.delete(friend);
            return true;
        } else {
            return false;
        }
    }
}
