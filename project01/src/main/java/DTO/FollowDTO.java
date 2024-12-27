package DTO;

import com.revatureproject01.project01.entity.Follow;

public class FollowDTO {
    private Integer followId;
    private AccountDTO follower;
    private AccountDTO followed;
    private Long timeCreatedEpoch;

    public FollowDTO(Follow follow) {
        this.followId = follow.getFollowId();
        this.follower.setAccountId(follow.getFollower().getAccountId());
        this.follower.setProfilePictureUrl(follow.getFollower().getProfilePicture());
        this.follower.setUsername(follow.getFollower().getUsername());

        this.followed.setAccountId(follow.getFollowed().getAccountId());
        this.followed.setProfilePictureUrl(follow.getFollowed().getProfilePicture());
        this.followed.setUsername(follow.getFollowed().getUsername());
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public AccountDTO getFollower() {
        return follower;
    }

    public void setFollower(AccountDTO follower) {
        this.follower = follower;
    }

    public AccountDTO getFollowed() {
        return followed;
    }

    public void setFollowed(AccountDTO followed) {
        this.followed = followed;
    }

    public Long getTimeCreatedEpoch() {
        return timeCreatedEpoch;
    }

    public void setTimeCreatedEpoch(Long timeCreatedEpoch) {
        this.timeCreatedEpoch = timeCreatedEpoch;
    }

}
