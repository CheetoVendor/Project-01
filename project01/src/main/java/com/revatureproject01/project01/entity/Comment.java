package com.revatureproject01.project01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @Column(name = "post_id")
    private Integer postId;
    @Column(name = "posted_by")
    private Integer postedBy;
    @Column(name = "comment_text")
    private String text;
    @Column(name = "time_posted_epoch")
    private Long timePostedEpoch;
    @Column(name = "time_updated_epoch")
    private Long timeUpdatedEpoch;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Integer postedBy) {
        this.postedBy = postedBy;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTimePostedEpoch() {
        return timePostedEpoch;
    }

    public void setTimePostedEpoch(Long timePostedEpoch) {
        this.timePostedEpoch = timePostedEpoch;
    }

    public Long getTimeUpdatedEpoch() {
        return timeUpdatedEpoch;
    }

    public void setTimeUpdatedEpoch(Long timeUpdatedEpoch) {
        this.timeUpdatedEpoch = timeUpdatedEpoch;
    }

}
