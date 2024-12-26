package com.revatureproject01.project01.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revatureproject01.project01.entity.Like;
import com.revatureproject01.project01.service.ReactionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReactionController {
    ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    // TODO - get reactions on post
    @GetMapping("/posts/{postId}/likes")
    public ResponseEntity getReactionsOnPost(@PathVariable Integer postId) {
        List<Like> likes = reactionService.getReactionsByPostId(postId);
        return ResponseEntity.status(200).body(likes);
    }

    // todo - add reaction
    @PostMapping("/posts/{postId}/likes")
    public ResponseEntity createReaction(@PathVariable Integer postId, @RequestBody Like like) {
        like.setPostId(postId);

        Like liked = reactionService.addReaction(like);
        return ResponseEntity.status(200).body(liked);
    }

    // delete reaction
    @DeleteMapping("/posts/{postId}/likes/{accountId}/{type}")
    public ResponseEntity<String> deleteReaction(@PathVariable Integer postId, @PathVariable Integer accountId,
            @PathVariable Integer type) {
        int removed = reactionService.removeReaction(postId, accountId, type);
        return ResponseEntity.status(200).body(removed + "removed");
    }

    // update reaction
    @PatchMapping("/posts/{postId}/likes/{likeId}")
    public ResponseEntity updateReaction(@RequestBody Like like) {
        Like updatedLike = reactionService.updateReaction(like);
        return ResponseEntity.status(200).body(updatedLike);
    }

    @GetMapping("/likes/{postId}/{userId}/{type}")
    public boolean isPostLikedByUser(@PathVariable Integer postId, @PathVariable Integer userId,
            @PathVariable Integer type) {

        boolean liked = reactionService.isPostLiked(postId, userId, type);
        return liked;
    }
}
