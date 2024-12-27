package DTO;

import com.revatureproject01.project01.entity.Friend;

public class FriendDTO {
    private Integer friendId;
    private Integer friendStatus;
    private AccountDTO friender;
    private AccountDTO friended;
    private Long timeCreatedEpoch;

    public FriendDTO(Friend friend) {
        this.friendId = friend.getFriendId();
        this.friendStatus = friend.getFriendStatus();

        this.friender = new AccountDTO();
        this.friended = new AccountDTO();

        this.friender.setAccountId(friend.getFriender().getAccountId());
        this.friender.setProfilePictureUrl(friend.getFriender().getProfilePicture());
        this.friender.setUsername(friend.getFriender().getUsername());

        this.friended.setAccountId(friend.getFriended().getAccountId());
        this.friended.setProfilePictureUrl(friend.getFriended().getProfilePicture());
        this.friended.setUsername(friend.getFriended().getUsername());

        this.timeCreatedEpoch = friend.getTimeCreatedEpoch();
    }

    public Integer getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(Integer friendStatus) {
        this.friendStatus = friendStatus;
    }

    public AccountDTO getFriender() {
        return friender;
    }

    public void setFriender(AccountDTO friender) {
        this.friender = friender;
    }

    public AccountDTO getFriended() {
        return friended;
    }

    public void setFriended(AccountDTO friended) {
        this.friended = friended;
    }

    public Long getTimeCreatedEpoch() {
        return timeCreatedEpoch;
    }

    public void setTimeCreatedEpoch(Long timeCreatedEpoch) {
        this.timeCreatedEpoch = timeCreatedEpoch;
    }
}
