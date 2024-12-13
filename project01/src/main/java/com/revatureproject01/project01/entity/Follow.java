package com.revatureproject01.project01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "follow")
public class Follow {
    @Id
    @Column(name = "follower_id")
    private Integer followerId;
    @Column(name = "followed_id")
    private Integer followedId;
    @Column(name = "time_created_epoch")
    private Long timeCreatedEpoch;

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }

    public Integer getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Integer followedId) {
        this.followedId = followedId;
    }

    public Long getTimeCreatedEpoch() {
        return timeCreatedEpoch;
    }

    public void setTimeCreatedEpoch(Long timeCreatedEpoch) {
        this.timeCreatedEpoch = timeCreatedEpoch;
    }
}
