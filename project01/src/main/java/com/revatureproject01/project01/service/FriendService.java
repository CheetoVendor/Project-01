package com.revatureproject01.project01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureproject01.project01.entity.Friend;
import com.revatureproject01.project01.repository.FriendRepository;

@Service
public class FriendService {

    FriendRepository friendRepository;

    @Autowired
    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    // get users friends that are accepted
    public List<Friend> getFriends(Integer userId) {
        return friendRepository.findByFrienderIdOrFriendedIdAndFriendStatus(userId, userId, 1);
    }

    // get users pending friend requests sent
    public List<Friend> getPendingFriendRequests(Integer userId) {
        return friendRepository.findByFrienderIdAndFriendStatus(userId, 0);
    }
    // get users pending friend requests received
}
