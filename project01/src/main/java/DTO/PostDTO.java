package DTO;

import com.revatureproject01.project01.entity.Post;

public class PostDTO {
    private Integer postId;
    private AccountDTO postedBy;
    private String postText;
    private String imageUrl;
    private String videoUrl;

    public PostDTO(Post post) {
        this.postId = post.getPostId();

        this.postedBy = new AccountDTO();

        this.postedBy.setAccountId(post.getPostedBy().getAccountId());
        this.postedBy.setProfilePictureUrl(post.getPostedBy().getProfilePicture());
        this.postedBy.setUsername(post.getPostedBy().getUsername());

        this.postText = post.getPostText();
        this.imageUrl = post.getImageUrl();
        this.videoUrl = post.getVideoUrl();
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public AccountDTO getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(AccountDTO postedBy) {
        this.postedBy = postedBy;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
