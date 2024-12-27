package DTO;

import com.revatureproject01.project01.entity.Account;

public class AccountDTO {
    private Integer accountId;
    private String username;
    private String profilePictureUrl;

    public AccountDTO() {

    }

    public AccountDTO(Account account) {
        this.accountId = account.getAccountId();
        this.username = account.getUsername();
        this.profilePictureUrl = account.getProfilePicture();
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}
