package com.revatureproject01.project01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revatureproject01.project01.entity.Comment;
import com.revatureproject01.project01.service.AccountService;
import com.revatureproject01.project01.service.CommentService;
import com.revatureproject01.project01.service.PostService;

@RestController
public class SocialMediaController {
    AccountService accountService;
    CommentService commentService;
    PostService postService;

    @Autowired
    public SocialMediaController(AccountService accountService, PostService postService,
            CommentService commentService) {
        this.accountService = accountService;
        this.commentService = commentService;
        this.postService = postService;
    }

    // #region Comments
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity getCommentsByPost(@PathVariable Integer postId) {
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        return ResponseEntity.status(200).body(comments);
    }

    // #endregion
}
