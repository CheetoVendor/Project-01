package com.revatureproject01.project01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Column(name = "friender_id")
    private Integer frienderId;
    @Column(name = "friended_id")
    private Integer friendedId;
    @Column(name = "time_created_epoch")
    private Long timeCreatedEpoch;

}
