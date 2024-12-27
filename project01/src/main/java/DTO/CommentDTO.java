package DTO;

import com.revatureproject01.project01.entity.Comment;

public class CommentDTO {
    private Integer commentId;
    private Integer postId;
    private AccountDTO postedBy;
    private String text;
    private Long timePostedEpoch;
    private Long timeUpdatedEpoch;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public AccountDTO getPostBy() {
        return postedBy;
    }

    public void setPostBy(AccountDTO postBy) {
        this.postedBy = postBy;
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

    public CommentDTO(Comment comment) {
        this.commentId = comment.getCommentId();
        this.postId = comment.getPostId();
        this.text = comment.getText();
        this.timePostedEpoch = comment.getTimePostedEpoch();
        this.timeUpdatedEpoch = comment.getTimeUpdatedEpoch();

        this.postedBy.setAccountId(comment.getPostedBy().getAccountId());
        this.postedBy.setProfilePictureUrl(comment.getPostedBy().getProfilePicture());
        this.postedBy.setUsername(comment.getPostedBy().getUsername());
    }
}
