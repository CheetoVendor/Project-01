package com.revatureproject01.project01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    // TODO - add a comment
    /*
     * @PostMapping("/posts/{postId}/comments")
     * public ResponseEntity createComment(@RequestBody Comment comment) {
     * // Comment comment = commentService.addComment(comment)
     * }
     */
    // TODO - delete a comment

    // UPDATE A COMMENT

}
