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

    // TODO - add comment
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // TODO - remove comment
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

    // TODO - find comments for a post
    public List<Comment> getCommentsByPostId(Integer postId) {
        return commentRepository.findByPostId(postId);
    }

    // TODO - update comment
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
