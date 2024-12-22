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
@Table(name = "friend")
public class Friend {
    @Id
    @Column(name = "friend_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer friendId;

    @Column(name = "friend_status")
    private Integer friendStatus;

    @ManyToOne
    @JoinColumn(name = "friender_id", referencedColumnName = "account_id")
    private Account friender;

    @ManyToOne
    @JoinColumn(name = "friended_id", referencedColumnName = "account_id")
    private Account friended;

    @Column(name = "time_created_epoch")
    private Long timeCreatedEpoch;

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Integer getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(Integer friendStatus) {
        this.friendStatus = friendStatus;
    }

    public Account getFriender() {
        return friender;
    }

    public void setFriender(Account friender) {
        this.friender = friender;
    }

    public Account getFriended() {
        return friended;
    }

    public void setFriended(Account friended) {
        this.friended = friended;
    }

    public Long getTimeCreatedEpoch() {
        return timeCreatedEpoch;
    }

    public void setTimeCreatedEpoch(Long timeCreatedEpoch) {
        this.timeCreatedEpoch = timeCreatedEpoch;
    }

}
