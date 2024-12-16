package com.revatureproject01.project01.service;

import com.revatureproject01.project01.repository.CommentRepository;

public class CommentService {
    CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
