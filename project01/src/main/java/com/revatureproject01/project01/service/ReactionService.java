package com.revatureproject01.project01.service;

import java.util.List;
import java.util.Optional;

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
    public int removeReaction(Like like) {
        Optional<Like> optionalLike = likeRepository.findById(like.getLikeId());
        if (optionalLike.isPresent()) {
            Like rm = optionalLike.get();
            likeRepository.delete(rm);
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
}
