package com.revatureproject01.project01.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revatureproject01.project01.entity.Like;
import com.revatureproject01.project01.service.ReactionService;

@RestController
public class ReactionController {
    ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    // TODO - get reactions on post
    @RequestMapping("/posts/{postId}/likes")
    public ResponseEntity getReactionsOnPost(@PathVariable Integer postId) {
        List<Like> likes = reactionService.getReactionsByPostId(postId);
        return ResponseEntity.status(200).body(likes);
    }

    // todo - add reaction
    @PostMapping("/posts/{postId}/likes")
    public ResponseEntity createReaction(@RequestBody Like like) {
        Like liked = reactionService.addReaction(like);
        return ResponseEntity.status(200).body(liked);
    }

    // delete reaction
    @DeleteMapping("/posts/{postId}/likes/{likeId}")
    public ResponseEntity deleteReaction(@RequestBody Like like) {
        int rows = reactionService.removeReaction(like);
        if (rows > 0) {
            return ResponseEntity.status(200).body(rows);
        } else {
            return ResponseEntity.status(200).body("");
        }
    }

    // update reaction
    @PatchMapping("/posts/{postId}/likes/{likeId}")
    public ResponseEntity updateReaction(@RequestBody Like like) {
        Like updatedLike = reactionService.updateReaction(like);
        return ResponseEntity.status(200).body(updatedLike);
    }

    @GetMapping("/posts/{postId}/likes")
    public boolean isPostLiked(@PathVariable Integer postId, @PathVariable Integer accountId,
            @PathVariable Integer type) {
        return reactionService.isPostLiked(postId, accountId, type);

    }
}
