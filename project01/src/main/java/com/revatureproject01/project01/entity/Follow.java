package com.revatureproject01.project01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "follow")
public class Follow {
    @Id
    @Column(name = "follow_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer followId;

    @ManyToOne
    @JoinColumn(name = "follower_id", referencedColumnName = "account_id")
    private Account follower;

    @ManyToOne
    @JoinColumn(name = "followed_id", referencedColumnName = "account_id")
    private Account followed;

    @Column(name = "time_created_epoch")
    private Long timeCreatedEpoch;

    public Account getFollower() {
        return follower;
    }

    public void setFollower(Account follower) {
        this.follower = follower;
    }

    public Account getFollowed() {
        return followed;
    }

    public void setFollowed(Account followed) {
        this.followed = followed;
    }

    public Long getTimeCreatedEpoch() {
        return timeCreatedEpoch;
    }

    public void setTimeCreatedEpoch(Long timeCreatedEpoch) {
        this.timeCreatedEpoch = timeCreatedEpoch;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }
}
