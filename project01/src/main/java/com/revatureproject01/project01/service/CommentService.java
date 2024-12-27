package com.revatureproject01.project01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureproject01.project01.entity.Comment;
import com.revatureproject01.project01.repository.CommentRepository;

@Service
public class CommentService {
    CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // Adds a comment
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // Removes a comment
    public int removeComment(Comment comment) {
        Optional<Comment> optionalComment = commentRepository.findById(comment.getCommentId());
        if (optionalComment.isPresent()) {
            Comment rm = optionalComment.get();
            commentRepository.delete(rm);
            return 1;
        } else {
            return 0;
        }
    }

    // Gets the comments on a post by post id
    public List<Comment> getCommentsByPostId(Integer postId) {
        return commentRepository.findByPostId(postId);
    }

    // updates a comment
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
