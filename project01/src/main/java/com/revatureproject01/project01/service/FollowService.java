package com.revatureproject01.project01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureproject01.project01.repository.FollowRepository;

@Service
public class FollowService {
    FollowRepository followRepository;

    @Autowired
    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

}
