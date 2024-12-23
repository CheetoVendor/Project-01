package com.revatureproject01.project01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureproject01.project01.entity.Like;
import com.revatureproject01.project01.repository.LikeRepository;

@Service
public class ReactionService {
    LikeRepository likeRepository;

    @Autowired
    public ReactionService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    // TODO - add reaction
    public Like addReaction(Like like) {
        return likeRepository.save(like);
    }

    // TODO - remove reaction
    public int removeReaction(Integer postId, Integer userId, Integer type) {
        Like optionalLike = likeRepository.findByPostIdAndAccountIdAndType(postId, userId, type);
        if (optionalLike != null) {
            likeRepository.delete(optionalLike);

            return 1;
        } else {
            return 0;
        }
    }

    // TODO - EDIT REACTION
    public Like updateReaction(Like like) {
        return likeRepository.save(like);
    }

    // TODO - get reactions by post id
    public List<Like> getReactionsByPostId(Integer postId) {
        return likeRepository.findByPostId(postId);
    }

    // See if post is liked
    public boolean isPostLiked(Integer postId, Integer accountId, Integer type) {
        Like like = likeRepository.findByPostIdAndAccountIdAndType(postId,
                accountId, type);

        if (like != null) {
            return true;
        } else {
            return false;
        }
    }

}
