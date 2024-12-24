package com.revatureproject01.project01.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.entity.Comment;
import com.revatureproject01.project01.service.CommentService;

@RestController
public class CommentController {
    CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // TODO - get comments on a post
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity getCommentsForPost(@PathVariable Integer postId) {
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        return ResponseEntity.status(200).body(comments);
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity createComment(@PathVariable Integer postId, @RequestBody Map<String, Object> commentData) {
        String text = (String) commentData.get("text");
        Integer accountId = Integer.parseInt((String) commentData.get("accountId"));

        Comment comment = new Comment();
        comment.setPostId(postId);
        comment.setText(text);
        Account x = new Account();
        x.setAccountId(accountId);
        comment.setPostedBy(x);
        comment.setTimePostedEpoch(System.currentTimeMillis());
        comment.setTimeUpdatedEpoch(System.currentTimeMillis());

        comment = commentService.addComment(comment);
        return ResponseEntity.status(200).body(comment);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Integer commentId) {
        Comment comment = new Comment();
        comment.setCommentId(commentId);
        int x = commentService.removeComment(comment);
        return ResponseEntity.status(200).body(x + "removed");
    }

}
